import {
    IsString, 
    IsNotEmpty, 
    IsPhoneNumber,     
} from 'class-validator';

export class UpdateProductDTO {
    @IsPhoneNumber()
    name: string;


    constructor(data: any) {
        this.name = data.name;
    }
}