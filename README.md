# Finite-State-Machine
Finite State Machines zijn de basis voor veel simulaties en AI in bijvoorbeeld games. Zonder daar al te diep op in te gaan kunnen we ze gebruiken om de kracht van OO programmeren te tonen. Je kunt namelijk een FSM implementeren met stukken minder code en bijzonder flexibel door OO technieken toe te passen.

## Custom FSM machine
Voor mijn eigen machine heb ik gekozen voor een alle wegen leiden naar Rome idee. Ik heb een aantal steden gepakt met wegen naar elkaar.

## DSL
1. Maak in de project root een nieuw text bestand aan.
2. Maak in dit text bestand 2 'checkpoints'
    1. `// Nodes`
    2. `// Connections`
3. Voeg vervolgend onder `// Nodes` uw gewenste nodes toe op volgende wijze:
    1. `variableName,NodeNaam`
4. Geef vervolgens de start node aan als volgt:
    1. Voeg `^^` aan het begin van de regel
5. Geef vervolgens alle connecties aan onder `// Connections` op de volgende wijze:
    1. `variableNameBeginConnectie>variableNameEndConnection>triggerCharacter`
6. Roep nu het juiste text bestand aan in de Main