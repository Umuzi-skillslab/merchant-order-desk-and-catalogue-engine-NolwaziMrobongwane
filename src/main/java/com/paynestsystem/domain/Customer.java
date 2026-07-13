package com.paynestsystem.domain;

public class Customer {
   private int id;
   private String name;
   private String email;

   public Customer(int var1, String var2, String var3) {
      this.id = var1;
      this.name = var2;
      this.email = var3;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getEmail() {
      return this.email;
   }
}
