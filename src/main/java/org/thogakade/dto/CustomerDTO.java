package org.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
   private String customerID;
   private String name;
   private String email;
   private String phone;
   private double salary;
   private byte [] image;

   public CustomerDTO(String customerID, String name, String email, String phone, double salary) {
      this.customerID = customerID;
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.salary = salary;
   }
}
