# Einfache Suche

**Wie lautet ein konkretes Pattern, so dass die Anzahl Zeichenvergleiche für die Suche
minimal wird? Wie viele Zeichenvergleiche sind es in diesem Fall genau?**

'a' -> 1

**Wie lautet ein konkretes Pattern, so dass die Anzahl Zeichenvergleiche maximal wird? Wie
viele Zeichenvergleiche sind es dann genau?**

"aaaaaaa...a" mit n = 100000 -> 100000

**Welche Laufzeitkomplexität besitzt die "einfache Suche"?**

O(n * m)

# Optimierter Suchautomat

**Welche Vorteile hat das Suchen mit Hilfe eines optimierten Suchautomaten im Vergleich
zu einer einfachen Suche?**

Effizienz

**Zeichnen Sie einen optimierten Suchautomaten für das Suchen nach dem Pattern
"ANANAS" auf. Das Alphabet beinhalte folgende Symbole A = {'A', 'N', 'S', ….}.**

Siehe `ANANAS-search.plantuml`

**Zeichnen Sie einen optimierten Suchautomaten für das Suchen nach dem Pattern
"EISBEIN" auf. Das Alphabet beinhalte folgende Symbole A = {'B', 'E', 'I', 'N', 'S', ….}**

Siehe `EISBEIN-search.plantuml`

**Inwiefern werden sich die Implementierungen für die Suche nach "ANANAS" bzw. "
EISBEIN" prinzipiell von jener nach dem binären Pattern "101011" aus dem Input
unterscheiden?**

Gar nicht?

**Implementieren Sie eine Methode
`public static int stateSearch(final String a)`
welche nach dem Pattern "ANANAS" sucht. Testen Sie Ihre Methode.**