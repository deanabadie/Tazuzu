export interface IPayload {
    activityTypes: Array < { activityName: string; measurementTypeId: string; id: number;} >,
    classes: Map < number, Array<{id: number; name: string; }>>,
    schools: Array<{ id: number; name: string; city: string; }>
};