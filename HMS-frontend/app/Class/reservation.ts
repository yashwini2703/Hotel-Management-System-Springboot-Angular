import { Hotel } from "./hotel";

export class Reservation {
    rsvid!: number;
    hotel: Hotel = {
        hid: 1,
        hotelname: undefined,
        city: undefined
      };
    firstName!: string;
    lastName!: string;
    address!:string;
    city!:string;
    state!: string;
    pincode!: string;
    phoneNumber!: number;
    emailAddress!: string;
    roomType!: string;
    adults!: Number;
    childrens!: Number;

    checkInDate!: Date; // Format: 'yyyy-MM-dd'
    checkOutDate!: Date; // Format: 'yyyy-MM-dd'
}
