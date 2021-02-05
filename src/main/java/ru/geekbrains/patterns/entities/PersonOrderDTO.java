package ru.geekbrains.patterns.entities;

import ru.geekbrains.patterns.utils.state.OrderCompleteState;
import ru.geekbrains.patterns.utils.state.State;
import ru.geekbrains.patterns.utils.visitor.Element;
import ru.geekbrains.patterns.utils.visitor.Visitor;

import java.time.LocalDate;

public class PersonOrderDTO implements OrderDTO, Cloneable, Element {

    private final Long id;
    private final String clientName;
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

    public PersonOrderDTO(Long id, String clientName, String phoneNumber, String comment, LocalDate createDate) {
        this.id = id;
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.createDate = createDate;
    }

    private PersonOrderDTO(PersonOrderDTOBuilder builder) {
        this.id = builder.id;
        this.clientName = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.comment = builder.comment;
        this.createDate = builder.createDate;
    }

        @Override
    public String getOrderInfo() {
        return "PersonOrderDTO{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public static PersonOrderDTOBuilder builder(){
        return new PersonOrderDTOBuilder();
    }

    @Override
    protected OrderDTO clone() throws CloneNotSupportedException {
        return new PersonOrderDTO(id, clientName, phoneNumber, comment, createDate);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static class PersonOrderDTOBuilder {
        private Long id;
        private String name;
        private String phoneNumber;
        private String comment;
        private LocalDate createDate;

        public PersonOrderDTOBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public PersonOrderDTOBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PersonOrderDTOBuilder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonOrderDTOBuilder setComment(String comment){
            this.comment = comment;
            return this;
        }

        public PersonOrderDTOBuilder setCreateDate(LocalDate createDate){
            this.createDate = createDate;
            return this;
        }

        public PersonOrderDTO build(){
            return new PersonOrderDTO(this);
        }
    }

}
