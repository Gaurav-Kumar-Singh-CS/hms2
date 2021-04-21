export interface Reservation {
    id: string;
    email: string;
    checkIn: string;
    checkOut: string;
    numberOfAdults: number;
    numberOfChildren: number;
    roomType: string;
    totalCost: Float32Array;

}