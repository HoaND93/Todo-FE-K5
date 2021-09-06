export interface TodoRequest {
    id?: number;
    title: string;
    note: string;
    deadline: string;
    status: number;
    category: number;
}