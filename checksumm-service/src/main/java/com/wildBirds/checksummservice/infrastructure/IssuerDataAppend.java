package com.wildBirds.checksummservice.infrastructure;

import com.wildBirds.checksummservice.domain.model.InnNumber;
import com.wildBirds.checksummservice.domain.model.Issuer;
import com.wildBirds.checksummservice.domain.port.InnNumberRepository;
import com.wildBirds.checksummservice.domain.port.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class IssuerDataAppend {

    @Autowired
    InnNumberRepository innNumberRepository;


    @Autowired
    IssuerRepository issuerRepository;

    @PostConstruct
    public void addPaymentCardsNumbers() {

        Issuer visa = issuerRepository.save(new Issuer("Visa"));
        InnNumber innNumber4 = innNumberRepository.save(new InnNumber("4"));
        visa.addInnNumber(innNumber4);
        issuerRepository.save(visa);



        Issuer americanExpress = issuerRepository.save(new Issuer("American Express"));
        InnNumber iin34 = innNumberRepository.save(new InnNumber("34"));
        InnNumber iin37 = innNumberRepository.save(new InnNumber("37"));
        americanExpress.addInnNumber(iin34);
        americanExpress.addInnNumber(iin37);
        issuerRepository.save(americanExpress);

        Issuer bankcard = issuerRepository.save(new Issuer("Bankcard"));
        InnNumber iin5610 = innNumberRepository.save(new InnNumber("5610"));
        InnNumber iin560221 = innNumberRepository.save(new InnNumber("560221"));
        InnNumber iin560222 = innNumberRepository.save(new InnNumber("560222"));
        InnNumber iin560223 = innNumberRepository.save(new InnNumber("560223"));
        InnNumber iin560224 = innNumberRepository.save(new InnNumber("560224"));
        InnNumber iin560225 = innNumberRepository.save(new InnNumber("560225"));
        bankcard.addInnNumber(iin5610);
        bankcard.addInnNumber(iin560221);
        bankcard.addInnNumber(iin560222);
        bankcard.addInnNumber(iin560223);
        bankcard.addInnNumber(iin560224);
        bankcard.addInnNumber(iin560225);
        issuerRepository.save(bankcard);


        Issuer chinaTUnion = issuerRepository.save(new Issuer("China T-Union"));
        InnNumber iin31 = innNumberRepository.save(new InnNumber("31"));
        chinaTUnion.addInnNumber(iin31);
        issuerRepository.save(chinaTUnion);

        Issuer chinaUnionPay = issuerRepository.save(new Issuer("China UnionPay"));
        InnNumber iin62 = innNumberRepository.save(new InnNumber("62"));
        chinaUnionPay.addInnNumber(iin62);
        issuerRepository.save(chinaUnionPay);


        Issuer dinersClubenRoute = issuerRepository.save(new Issuer("Diners Club enRoute"));
        InnNumber iin2014 = innNumberRepository.save(new InnNumber("2014"));
        InnNumber iin2149 = innNumberRepository.save(new InnNumber("2149"));
        dinersClubenRoute.addInnNumber(iin2014);
        dinersClubenRoute.addInnNumber(iin2149);
        issuerRepository.save(dinersClubenRoute);



        Issuer dinersClubInternational = issuerRepository.save(new Issuer("Diners Club International"));
        InnNumber iin36 = innNumberRepository.save(new InnNumber("36"));
        InnNumber iin300 = innNumberRepository.save(new InnNumber("300"));
        InnNumber iin301 = innNumberRepository.save(new InnNumber("301"));
        InnNumber iin302 = innNumberRepository.save(new InnNumber("302"));
        InnNumber iin303 = innNumberRepository.save(new InnNumber("303"));
        InnNumber iin304 = innNumberRepository.save(new InnNumber("304"));
        InnNumber iin305 = innNumberRepository.save(new InnNumber("305"));
        InnNumber iin3095 = innNumberRepository.save(new InnNumber("3095"));
        InnNumber iin38 = innNumberRepository.save(new InnNumber("38"));
        InnNumber iin39 = innNumberRepository.save(new InnNumber("39"));
        dinersClubInternational.addInnNumber(iin36);
        dinersClubInternational.addInnNumber(iin300);
        dinersClubInternational.addInnNumber(iin301);
        dinersClubInternational.addInnNumber(iin302);
        dinersClubInternational.addInnNumber(iin303);
        dinersClubInternational.addInnNumber(iin304);
        dinersClubInternational.addInnNumber(iin305);
        dinersClubInternational.addInnNumber(iin3095);
        dinersClubInternational.addInnNumber(iin38);
        dinersClubInternational.addInnNumber(iin39);
        issuerRepository.save(dinersClubInternational);


        Issuer dinersClub = issuerRepository.save(new Issuer("Diners Club United States & Canada"));
        InnNumber iin54 = innNumberRepository.save(new InnNumber("54"));
        InnNumber iin55 = innNumberRepository.save(new InnNumber("55"));
        dinersClub.addInnNumber(iin54);
        dinersClub.addInnNumber(iin55);
        issuerRepository.save(dinersClub);


        Issuer discoverCard = issuerRepository.save(new Issuer("Discover Card"));
        InnNumber iin6011 = innNumberRepository.save(new InnNumber("6011"));
        InnNumber iin64 = innNumberRepository.save(new InnNumber("64"));
        InnNumber iin65 = innNumberRepository.save(new InnNumber("65"));
        discoverCard.addInnNumber(iin6011);
        discoverCard.addInnNumber(iin64);
        discoverCard.addInnNumber(iin65);
        issuerRepository.save(discoverCard);

        Issuer ruPay = issuerRepository.save(new Issuer("RuPay"));
        InnNumber iin60 = innNumberRepository.save(new InnNumber("60"));
        InnNumber iin6521 = innNumberRepository.save(new InnNumber("6521"));
        InnNumber iin6522 = innNumberRepository.save(new InnNumber("6522"));
        ruPay.addInnNumber(iin60);
        ruPay.addInnNumber(iin6521);
        ruPay.addInnNumber(iin6522);
        issuerRepository.save(ruPay);


        Issuer interPayment = issuerRepository.save(new Issuer("InterPayment"));
        InnNumber iin636 = innNumberRepository.save(new InnNumber("636"));
        interPayment.addInnNumber(iin636);
        issuerRepository.save(interPayment);


        Issuer instaPayment = issuerRepository.save(new Issuer("InstaPayment"));
        InnNumber iin637 = innNumberRepository.save(new InnNumber("637"));
        InnNumber iin638 = innNumberRepository.save(new InnNumber("638"));
        InnNumber iin639 = innNumberRepository.save(new InnNumber("639"));
        instaPayment.addInnNumber(iin637);
        instaPayment.addInnNumber(iin638);
        instaPayment.addInnNumber(iin639);
        issuerRepository.save(instaPayment);


        Issuer jcb = issuerRepository.save(new Issuer("JCB"));

        for (int i = 3528; i <=3589 ; i++) {
            InnNumber innJCB = innNumberRepository.save(new InnNumber(String.valueOf(i)));
            jcb.addInnNumber(innJCB);
        }

        issuerRepository.save(jcb);


    }

}
