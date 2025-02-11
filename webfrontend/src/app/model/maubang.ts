import { MauBangImage } from "./maubangimage";

export interface MauBang {
  id: number;
  name: string;
  thumbnail: string;
  url: string;
  product_images: MauBangImage[];
}