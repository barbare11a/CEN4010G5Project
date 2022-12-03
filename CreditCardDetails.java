package com.bookstore.store.model;

import com.bookstore.store.repository.MySQLRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RestController
public class CreditCardDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
        MySQLRepository mySQLRepository;

        private Integer ccid;
        private String cctype;

        private Integer ccnumber;

        public Integer getCcid() {
            return ccid;
        }

        public void setCcid(Integer ccid) {

            this.ccid = ccid;
        }
        public String getCctype(){
            return cctype;
        }
        public void setCctype(String cctype){
            this.cctype = cctype;
        }
        public Integer getCcnumber() {

            return ccnumber;
        }

        public void setCcnumber(Integer ccnumber) {

            this.ccnumber = ccnumber;
        }

    }
