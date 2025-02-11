import {
    IsString, 
    IsNotEmpty, 
    IsPhoneNumber,     
} from 'class-validator';
import { MauBang } from '../../model/maubang';

export class InsertCassetteDTO {
    @IsString()
    name: string;

    @IsString()
    matA:string;

    @IsString()
    matB:string;

    otpName:number;

    maubangid:number;

    constructor(data: any) {
        this.name = data.name;
        this.matA = data.matA;
        this.matB = data.matB;
        this.otpName=data.otpName;
        this.maubangid=data.maubangid;
    }
}