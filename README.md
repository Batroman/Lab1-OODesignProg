# oopd-gu-chalmers Lab 1
Lab assignment 1 in the course Object-oriented Programming and Design, GU/Chalmers

See Canvas for instructions.

Vi har lagt alla duplicerade metoder och variabler i en superclass Car. (Implementationsarv)

Vår tanke är att det ska vara lätt att skapa en nytt objekt av Car som har alla nödvändiga funktioner, och att enskilda metoder och variabler kan overridas vid behov. 

Eftersom många metoder gör samma sak i Volvo och Saab tyckte vi att det verkade klokt att implementationsarv istället för abstrakta metoder (som inte ger några implementationer -- vilket vi behöver).

Synlighet:
Vi har gjort variabler och metoder som är specifika för subklasser private.

Vi har låtit resterande vara public för att de ska vara synliga och åtkomliga för subklasser och superklassen. 
