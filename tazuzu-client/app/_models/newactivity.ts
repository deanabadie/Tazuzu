export class NewActivity {
    type: {id: number; name: string; measurementTypeId: number, numOfMeasurements: number;};
    time: Date;
    isMandatory: boolean;
    classId: number;
    students: string;
    target: number;
}