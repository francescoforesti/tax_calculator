
##Tax Calculator

A kata-like example project about how to apply clean code to a simple use case.
Some remarks:
* The project is maven-based 
* the ReceiptService class is the main entry point of the project. 
  * It is assumed that such a class may be part of a repository/service/controller pattern in a 3-tiered application
* The ReceiptServiceTest contains the end to end test with the following inputs:

```
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
```
The tests verify that the outputs are equal to the following receipts:

```
Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```
* There are also unit tests to document and verify some details of the implementation, and to test the most tricky parts.
