export class Activity {
    activityName: string; //combobox need to get from DB
    measurementTypeId: number; //combobox hard coded 1-3
    numOfMeasurements: number; //combobox hard coded 1-3 
    activityDate: Date;
    isMandatory: string; //yes or no
    classId: string; //combobox need to get from DB
    studentIdList: string; //combobox need to get from DB
}