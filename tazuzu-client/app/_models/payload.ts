export interface SchoolClass {id: number; name: string; }
export interface ActivityType { activityName: string; measurementTypeId: string; id: number;}
export interface School { id: number; name: string; city: string; }
export interface IPayload {
    activityTypes: Array <ActivityType>,
    schools: Array<School>
    classes: Map < number, Array<SchoolClass>>,
};