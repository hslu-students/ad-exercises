# Quick search

**Woraus ergibt sich die Länge für das shift-Array? In welchem Bereich (min … max)
liegen die Zahlenwerte im shift-Array?**

Aus dem alphabet, bereich wird deffiniert durch die zeichen im pattern.

**Es gilt folgendes Alphabet: A = {a, b, c, d, e, f, g, h, i}. Wir wollen mit Quicksearch nach
dem Pattern "gaga" suchen. Mit welchen Werten muss dafür das Array shift initialisiert
werden?**

A = {
    a: 4,
    b: 5,
    c: 5,
    d: 5,
    e: 5,
    f: 5,
    g: 3,
    h: 5,
    i: 5
}

**Geben Sie zwei Extrembeispiele an, d.h. je eine Zeichenkette und ein Pattern, wo
Quicksearch**

- extrem schnell durch eine Zeichenkette "springt" bzw.
- langsam durch eine Zeichenkette "kriecht".

**Schätzen Sie die Anzahl erforderliche Zeichenvergleiche für diese Spezialfälle
verallgemeinert ab, und zwar in der Annahme, die Zeichenkette enthalte das Pattern nicht**

- schnell

p = 'aaaaa'
Z = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"

- langsam

p = 'aaaaaaba'
Z = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"