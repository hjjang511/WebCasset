import {
    IsString, 
    IsNotEmpty, 
    IsPhoneNumber,     
} from 'class-validator';

export class InsertProductDTO {
    @IsPhoneNumber()
    name: string;

    images: File[] = [];
    
    constructor(data: any) {
        this.name = data.name;
    }
}