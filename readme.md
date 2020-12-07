# Observer Pattern
_&copy; Novi Hogeschool. Geschreven door Nick Stuivenberg_

## Inleiding
In dit project vind je een voorbeeld van de Observer Pattern. De code is expres in drie packages opgedeeld om een 
duidelijke scheiding te geven tusseb de `observer` en de `subject` kant.

## Subject package
De subject package bevat de Subject-klasse, ook wel de publisher genoemd. De klasse zijn verantwoordelijk voor het
bijhouden van de observers en het notificeren van alle bijgehouden observers. 

Alle subject-klasse implementeren de Subject-interface. 

## Observer package
De observer-package bevate de Observer-klasse. Deze klasse worden ook wel subscribers genoemd en zijn de klasse die
code uitvoeren wanneer zij aangeroepen worden.

Alle observer-klasse implementeren de Observer interface. Deze interface bevat de `void update(Message message);`
-methode. In het message object zit alle informatie waarmee de concrete observer klasse moeten kunnen werken.

## Verdere werking
De theorie en de verdere werking van de code staat uitschreven in EdHub.