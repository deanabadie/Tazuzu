import { OnInit, Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActivityService, AlertService } from '../_services/index';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    templateUrl: './activity-results.component.html'
})
export class ActivityResults implements OnInit {

    private numApproved: number;

    private measurements: Array<{ id: number; activityInstance: { activityType: any }; }>;

    private activity: { activityDate: any };

    constructor(
        private activityService: ActivityService,
        private route: ActivatedRoute,
        private alertService: AlertService,
    ) { }

    private activityMapper(measurement) {
        let measure;
        switch (measurement.activityInstance.activityType.measurementTypeId) {
            case 'TIME':
                measure = measurement.resultTimeSeconds;
                break;
            case 'QUANTITY':
                measure = measurement.resultQuantity;
                break;
            case 'DISTANCE':
                measure = measurement.resultDistance;
                break;
        }

        return {
            ...measurement,
            measure
        };
    }

    updateResult(event, measurement: { id: number; student: {firstName: string; lastName: string;} }) {
        const value = event.target.value;
        this.activityService.updateMeasurementResult(measurement.id, value)
            .subscribe(result => {
                this.alertService.success(`Result for ${measurement.student.firstName} has been updated!`);
            });
    }

    updateGrade(event, measurement: { id: number; student: {firstName: string; lastName: string;} }) {
        const value = event.target.value;
        this.activityService.updateMeasurementGrade(measurement.id, value)
            .subscribe(result => {
                this.alertService.success(`Grade for ${measurement.student.firstName} has been updated!`);
            });
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.activityService.getMeasurementsByActivityInstanceId(+params.id)
                .map(measurements => measurements.map(this.activityMapper))
                .subscribe(measurements => {
                    this.numApproved = measurements.filter(m => m.participationApproval === true).length;
                    this.measurements = measurements;
                });

            this.activityService.get(+params.id)
                .map(activity => ({
                    ...activity,
                    formattedDate: moment(activity.activityDate).format('YYYY-MM-DD HH:MM:SS'),
                }))
                .subscribe(activity => {
                    this.activity = activity;
                });
        });
    }

}