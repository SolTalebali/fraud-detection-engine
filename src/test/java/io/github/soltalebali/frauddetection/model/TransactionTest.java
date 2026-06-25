package io.github.soltalebali.frauddetection.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionTest {
   @Test
    void testEqualsPositiveCase() {
       LocalDateTime dateTime = LocalDateTime.of(2026, 6, 25, 10, 30, 56);
       Transaction transaction1 = new Transaction("ABC", "JohnD",
               new BigDecimal("250.50"), dateTime, "London");

       Transaction transaction2 = new Transaction("ABC", "JohnD",
               new BigDecimal("250.50"), dateTime, "London");

       assertThat(transaction1, is(equalTo(transaction2)));
       assertEquals(transaction1, transaction2);
   }

   @Test
   void testEqualsNegativeCase() {
      LocalDateTime dateTime = LocalDateTime.of(2026, 6, 25,
              10, 30, 56);
      Transaction transaction1 = new Transaction("ABC", "JohnD",
              new BigDecimal("250.50"), dateTime, "London");

      Transaction transaction2 = new Transaction("ABB", "JohnD",
              new BigDecimal("250.50"), dateTime, "Birmingham");

      assertThat(transaction1,not(equalTo(transaction2)));
      assertNotEquals(transaction1, transaction2);
   }

   @Test
   void testToStringPositiveCase() {
      LocalDateTime dateTime = LocalDateTime.of(2026, 6, 25,
              10, 30, 56);
      Transaction transaction1 = new Transaction("ABC", "JohnD",
              new BigDecimal("250.50"), dateTime, "London");

      String string = transaction1.toString();
      String expected = "Transaction{transactionId='ABC', accountId='JohnD'," +
              " amount=250.50, timestamp=2026-06-25T10:30:56, location='London'}";

      assertThat(string, equalTo(expected));
   }
}
