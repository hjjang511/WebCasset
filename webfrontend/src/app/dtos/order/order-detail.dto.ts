import { IsNumber,
    IsString
 } from 'class-validator';

export class OrderDetailDTO {
    @IsNumber()
    maubang_id: number;

    @IsNumber()
    otpName: number;

    @IsString()
    matA:string;

    @IsString()
    matB:string;

    @IsString()
    name:string;

    @IsNumber()
    number_product: number;

    @IsNumber()
    total_money:number;
    constructor(data: any) {
        this.maubang_id = data.maubang_id;
        this.otpName = data.otpName;
        this.matA=data.matA;
        this.matB=data.matB;
        this.name=data.name;
        this.number_product=data.number_product;
        this.total_money=data.total_money
    }
}
