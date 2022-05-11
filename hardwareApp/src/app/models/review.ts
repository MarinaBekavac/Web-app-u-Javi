import { Rating } from "./rating";

export interface Review{
    id: number;
    hardwareId: number;
    title: string;
    description: string;
    rating: Rating;
}