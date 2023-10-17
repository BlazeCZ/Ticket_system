# Ticket_system
Jednoduchý program na tvorbu a obsluhu ticketovacího systému (fronty)



ZADÁNÍ

Napište program, který bude vystavovat REST rozhraní pro ticketovací systém na pobočce (s využitím Spring Boot). Ten by měl vystavovat následující REST služby: 
- Vygenerování pořadového čísla, s tím že vracet bude navíc ještě datum a čas vygenerování a pořadí ve frontě 
- Získání aktuálního aktivního čekajícího čísla 
- Smazání posledního aktivního čísla 

Například: 
V seznamu aktivních ticketů bude:  
- 1245, 2017-09-01 15:22, 0 
- 1246, 2017-09-01 15:42, 1 
- 1250, 2017-09-01 16:32, 2 

Vygenerování nového vrátí: 
- 1251, 2017-09-01 19:20, 3 

Získání aktuálního vrátí: 
- 1245, 2017-09-01 15:22, 0 

Po smazání posledního bude v seznamu: 
- 1246, 2017-09-01 15:42, 0 
- 1250, 2017-09-01 16:32, 1 
- 1251, 2017-09-01 19:20, 2 
