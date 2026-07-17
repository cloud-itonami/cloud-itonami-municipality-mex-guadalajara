(ns culture.facts
  "Regional-culture catalog for Guadalajara -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"guadalajara"
   [{:culture/id "guadalajara.dish.torta-ahogada"
     :culture/name "Torta ahogada"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :dish
     :culture/summary "Sandwich of birote bread submerged in chile de arbol sauce, typical of the state of Jalisco and particularly of the city of Guadalajara."
     :culture/url "https://en.wikipedia.org/wiki/Torta_ahogada"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.dish.birria"
     :culture/name "Birria"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :dish
     :culture/summary "Regional variation of barbacoa from western Mexico, mainly goat, beef or lamb; the term originated in the state of Jalisco for meats cooked in a pit or earth oven."
     :culture/url "https://en.wikipedia.org/wiki/Birria"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.dish.carne-en-su-jugo"
     :culture/name "Carne en su jugo"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :dish
     :culture/summary "Chopped beef cooked in its own juices with beans and bacon, representative of Jalisco's gastronomy and particularly associated with Guadalajara's Santa Tere neighborhood."
     :culture/url "https://es.wikipedia.org/wiki/Carne_en_su_jugo"
     :culture/url-provenance :wikipedia-es
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.dish.jericalla"
     :culture/name "Jericalla"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :dish
     :culture/summary "Custard-like dessert of milk, eggs, vanilla, cinnamon and sugar, typical of Jalisco and originating in the city of Guadalajara, reportedly first prepared by nuns at the Hospicio Cabanas."
     :culture/url "https://es.wikipedia.org/wiki/Jericalla"
     :culture/url-provenance :wikipedia-es
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.beverage.tequila"
     :culture/name "Tequila"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :beverage
     :culture/summary "Distilled beverage made from blue agave, primarily in the area surrounding the town of Tequila in Jalisco, Guadalajara's state; a protected designation-of-origin product in the EU since 1997."
     :culture/url "https://en.wikipedia.org/wiki/Tequila"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.beverage.tejuino"
     :culture/name "Tejuino"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :beverage
     :culture/summary "Cold, sugary fermented corn beverage popularly consumed in Jalisco, Colima and Nayarit; in Guadalajara it is often served with lime sorbet."
     :culture/url "https://en.wikipedia.org/wiki/Tejuino"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.festival.encuentro-internacional-del-mariachi"
     :culture/name "International Mariachi and Charreria Encounter"
     :culture/name-local "Encuentro Internacional del Mariachi y la Charrería"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :festival
     :culture/summary "Annual cultural festival founded in 1994 to preserve mariachi music and charreria traditions, held in the state of Jalisco with main headquarters in Guadalajara."
     :culture/url "https://es.wikipedia.org/wiki/Encuentro_Internacional_del_Mariachi_y_la_Charrer%C3%ADa"
     :culture/url-provenance :wikipedia-es
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.festival.guadalajara-international-book-fair"
     :culture/name "Guadalajara International Book Fair"
     :culture/name-local "Feria Internacional del Libro de Guadalajara"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :festival
     :culture/summary "Largest book fair in the Americas and second-largest in the world after Frankfurt's, held annually in Guadalajara for nine days from the last Saturday in November."
     :culture/url "https://en.wikipedia.org/wiki/Guadalajara_International_Book_Fair"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.heritage.mariachi"
     :culture/name "Mariachi"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :heritage
     :culture/summary "Music genre whose modern form originated in Cocula, Jalisco, celebrated at Guadalajara's International Mariachi Festival and recognized by UNESCO as Intangible Cultural Heritage in 2011."
     :culture/url "https://en.wikipedia.org/wiki/Mariachi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "guadalajara.heritage.hospicio-cabanas"
     :culture/name "Hospicio Cabañas"
     :culture/municipality "guadalajara"
     :culture/country "MEX"
     :culture/kind :heritage
     :culture/summary "Former orphanage and hospital complex in Guadalajara built 1796-1810, a UNESCO World Heritage Site since 1997, now a museum housing frescoes by Jose Clemente Orozco."
     :culture/url "https://en.wikipedia.org/wiki/Hospicio_Caba%C3%B1as"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-mex-guadalajara culture catalog "
                 "(ADR-2607171400): " (count (get catalog "guadalajara"))
                 " Guadalajara entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
