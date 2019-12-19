## Aplikacja do obsługi aukcji

##### Podczas rezalizowania zadań proszę pamiętaj o następujących rzeczach:
1. Możesz dowolnie modyfikować kod, jednak należy zachować funkcjonalność biznesową.

2. Usuwaj niepotrzebne elementy.

3. Pamiętaj o zasadach dobrego programowania.

4. Niewszystkie encje będą posiadały wszystkie metody CRUD..

5. Jeżeli jest to możliwe pisz testy jednostkowe i/lub integracyjne.

#### 1. Stosując poznane asocjacje połącz poszczególne encje.
1. Category zawiera listę Items.
2. Item zawiera relację do Category.
3. Item zawiera listę Bids.
4. Person zawiera listę Bids.
5. Person zawiera listę Addresses, wykorzystaj adnotację @ElementCollection.
6. Bid zawiera relację do Item i Person.

#### 2.  Stwórz i zaimplementuj odpowiednie interfejsy dla poszczególnych encji

 