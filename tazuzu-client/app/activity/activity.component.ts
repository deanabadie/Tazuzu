import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { User } from '../_models/index';
import { UserService, ActivityService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'activity.component.html'
})
export class ActivityComponent implements OnInit {

    currentUser: User;

    //Activity object, holds the activity general meta data
    activity: any;

    //ActivityInstanceMeasurements
    measurements: Array<any>;

    public barChartType: string = 'bar';

    public barChartOptions: any = {
        scaleShowVerticalLines: false,
        responsive: true,
        title: {
            display: true,
            text: 'Results chart'
        },
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    };

    public barChartLabels: Array<string>;

    public barChartLegend = false;

    public barChartData: Array<any>;

    constructor(
        private userService: UserService,
        private route: ActivatedRoute,
        private activityService: ActivityService
    ) { }

    private activityMapper(measurement, scale = false) {
        let measure;
        switch (measurement.activityInstance.activityType.measurementTypeId) {
            case 'TIME':
                measure = measurement.resultTimeSeconds / 60;
                break;
            case 'QUANTITY':
                measure = measurement.resultQuantity;
                break;
            case 'DISTANCE':
                measure = measurement.resultDistance;
                break;
        }

        return scale ? measure * 0.9 : measure;
    };

    private titles = {
        DISTANCE: 'Distance (Meters)',
        QUANTITY: 'Quantity',
        TIME: 'Time (Minutes)',
    };

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];

        this.route.params.subscribe(params => {
            //First observable is to get the activity instance id from the url

            //Fetch the general activity meta data
            this.activityService.get(+params.id)
                .subscribe(activityInstance => {
                    activityInstance.formattedDate = moment(activityInstance.activityDate).format('YYYY-MM-DD HH:MM:SS');
                    this.activity = activityInstance;
                    this.barChartOptions.title.text = this.titles[activityInstance.activityType.measurementTypeId];
                });

            //Fetch activity measurements/participants
            this.activityService.getMeasurementsByActivityInstanceId(+params.id)
                .subscribe(measurements => {
                    this.barChartLabels = measurements.map(m => m.student.firstName + ' ' + m.student.lastName)
                    this.barChartData = [
                        {
                            data: measurements.map(m => this.activityMapper(m)),
                            label: 'Result 1'
                        },
                        {
                            data: measurements.map(m => this.activityMapper(m, true)),
                            label: 'Result 2'
                        }
                    ];

                    this.measurements = measurements;
                });

        });
    }

}