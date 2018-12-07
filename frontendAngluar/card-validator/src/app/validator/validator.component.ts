import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CardDTO} from "./card-dto";



@Component({
    selector: 'app-validator',
    templateUrl: './validator.component.html',
    styleUrls: ['./validator.component.scss']
})
export class ValidatorComponent implements OnInit {

    private inputNumber: HTMLInputElement;

    private readonly host: string;

    private http: HttpClient;

    constructor() {
        this.host = 'http://localhost:8090/card/4516895819549900';
        // this.http = http;
    }

    ngOnInit() {

    }


    public validateCart() {
        const headers = new HttpHeaders();
        headers.set('Content-Type', 'application/json');
        headers.set('Access-Control-Allow-Origin', '*');
        headers.set('Access-Control-Allow-Origin', 'true');

        this.inputNumber = document.querySelector('#cardNumber');
        alert(this.inputNumber.value);
        console.log(this.inputNumber.value);
        var cardDTOObservable = this.http.get<CardDTO>(this.host);
        cardDTOObservable.subscribe(msg => {
            console.log("OK!!!!!!!!!!!!!")
            console.log(msg)
        });
    }

}
