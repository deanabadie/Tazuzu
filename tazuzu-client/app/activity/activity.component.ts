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

    activity: any;

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

    public barChartLabels: string[];

    public barChartLegend: boolean = false;

    public barChartData: any[];

    constructor(private userService: UserService, private route: ActivatedRoute, private activityService: ActivityService) {
    }

    private activityMapper(measurement) {
        switch (measurement.activityInstance.activityType.measurementTypeId) {
            case 'TIME':
                return measurement.resultTimeSeconds / 60;
            case 'QUANTITY':
                return measurement.resultQuantity;
            case 'DISTANCE':
                return measurement.resultDistance;
        }
        return null;
    };

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];

        this.route.params.subscribe(params => {
            this.activityService.get(+params.id)
                .subscribe(activityInstance => {
                    activityInstance.formattedDate = moment(activityInstance.activityDate).format('YYYY-MM-DD HH:MM:SS');
                    this.activity = activityInstance;

                    const titles = {
                        DISTANCE: 'Distance (Meters)',
                        QUANTITY: 'Quantity',
                        TIME: 'Time (Minutes)',
                    };

                    this.barChartOptions.title.text = titles[activityInstance.activityType.measurementTypeId];
                });

            this.activityService.getMeasurementsByActivityInstanceId(+params.id)
                .subscribe(measurements => {
                    this.barChartLabels = measurements.map(m => m.student.firstName + ' ' + m.student.lastName)
                    this.barChartData = [
                        {
                            data: measurements.map(m => this.activityMapper(m)),
                            label: 'Results'
                        }
                    ];

                    this.measurements = measurements;
                });
        });
    }

}