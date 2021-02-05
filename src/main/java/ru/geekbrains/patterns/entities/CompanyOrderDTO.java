package ru.geekbrains.patterns.entities;

import ru.geekbrains.patterns.utils.state.OrderCompleteState;
import ru.geekbrains.patterns.utils.state.State;
import ru.geekbrains.patterns.utils.visitor.Element;
import ru.geekbrains.patterns.utils.visitor.Visitor;

import java.time.LocalDate;

public class CompanyOrderDTO implements OrderDTO, Element {

    private final Long id;
    private final String clientName;
    private final Integer inn;
    private final String someImportantInfo;
    private final String phoneNumber;
    private final String comment;
    private final LocalDate createDate;

    private State orderState = new OrderCompleteState(this);

    public void setOrderState(State orderState){
        this.orderState = orderState;
    }

    public void cancel(){
        orderState.cancel();
    }

    public CompanyOrderDTO(Long id, String clientName, Integer inn, String someImportantInfo, String phoneNumber, String comment, LocalDate createDate) {
        this.id = id;
        this.clientName = clientName;
        this.inn = inn;
        this.someImportantInfo = someImportantInfo;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.createDate = createDate;
    }

    private CompanyOrderDTO(CompanyOrderDTOBuilder builder) {
        this.id = builder.id;
        this.clientName = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.comment = builder.comment;
        this.createDate = builder.createDate;
        this.inn = builder.inn;
        this.someImportantInfo = builder.someImportantInfo;
    }

    @Override
    public String getOrderInfo() {
        return "CompanyOrderDTO{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", inn=" + inn +
                ", someImportantInfo='" + someImportantInfo + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static CompanyOrderDTOBuilder builder(){
        return new CompanyOrderDTOBuilder();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static class CompanyOrderDTOBuilder {
        private Long id;
        private String name;
        private Integer inn;
        private String someImportantInfo;
        private String phoneNumber;
        private String comment;
        private LocalDate createDate;

        public CompanyOrderDTOBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public CompanyOrderDTOBuilder setName(String name){
            this.name = name;
            return this;
        }

        public CompanyOrderDTOBuilder setInn(Integer inn){
            this.inn = inn;
            return this;
        }

        public CompanyOrderDTOBuilder setSomeImportantInfo(String info){
            this.someImportantInfo = info;
            return this;
        }

        public CompanyOrderDTOBuilder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CompanyOrderDTOBuilder setComment(String comment){
            this.comment = comment;
            return this;
        }

        public CompanyOrderDTOBuilder setCreateDate(LocalDate createDate){
            this.createDate = createDate;
            return this;
        }

        public CompanyOrderDTO build(){
            return new CompanyOrderDTO(this);
        }
    }

}
