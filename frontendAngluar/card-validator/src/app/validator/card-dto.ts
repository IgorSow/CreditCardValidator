export class CardDTO {

    privatename: string;


    constructor(name: string) {
        this.name = name;
    }


    get name(): string {
        return this.name;
    }

    set name(value: string) {
        this.name = value;
    }
}
