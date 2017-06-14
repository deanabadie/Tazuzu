export interface Activity {
    activityName: string;
    measurementTypeId: number;
    numOfMeasurements: number; 
    activityDate: Date;
    isMandatory: string;
    classId: string;
    studentIdList: string;
}