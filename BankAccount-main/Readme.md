You have been given a bank program which allows you to deposit and withraw from a bank account.
The developer tried to use multhtreading to improve the performance but it is not working properly.
The developer created two threads each for depositing and withdrawing

If you run the program you will see the following output

```agsl
Starting balance $100.0
after deposit balance = $110.0
after deposit balance = $110.0
after withdraw balance = $90.0
after withdraw balance = $90.0
after deposit balance = $120.0
after deposit balance = $120.0
after withdraw balance = $80.0
after withdraw balance = $80.0
after deposit balance = $130.0
after deposit balance = $130.0
after withdraw balance = $70.0
after withdraw balance = $70.0
after deposit balance = $140.0
after withdraw balance = $60.0
after withdraw balance = $60.0
after deposit balance = $140.0
after deposit balance = $150.0
after withdraw balance = $50.0
after withdraw balance = $50.0
after deposit balance = $150.0
Closing balance $=150.0
```

The closing balance is wrong. 
Because each thread in the program withdraws $10 5 times and deposits $10 5 times.
So the total amount deposited should be $50x2 = $100.
Total amount withdrawn $50x2 = $100.

So the total balance should have been `$100` instead of `$150`.

Your job is to fix the code so that after running the program we get the correct balance.

- The deposit and withdraw method of Bank account class has an artificial delay to simulate processing. Do not remote that code.


