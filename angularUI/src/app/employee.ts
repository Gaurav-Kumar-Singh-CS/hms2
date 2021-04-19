import { address } from "./address";

export interface Employee {
    id: string;
    name: string,
    email: string,
    jobTitle: string,
    phone: string,
    address: address,
    salary: number
}