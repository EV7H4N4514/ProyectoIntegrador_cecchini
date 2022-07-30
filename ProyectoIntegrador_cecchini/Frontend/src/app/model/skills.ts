export class Skills {

    id?: number;
    nombreSk: string;
    porcentaje: string;
    imgSkills : string;

    constructor(nombreS: string, porcentajeS: string, imagenS: string) {
        this.nombreSk = nombreS;
        this.porcentaje = porcentajeS;
        this.imgSkills = imagenS;
    }


}
