(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Guadalajara (Jalisco,
  Mexico) -- the TWENTY-SIXTH municipality-level entry (see
  cloud-itonami-municipality-jpn-tokyo, -usa-washington-dc, -gbr-london,
  -can-toronto, -deu-berlin, -fra-paris, -nld-amsterdam, -esp-madrid,
  -kor-seoul, -ita-roma, -aus-sydney, -arg-buenos-aires, -fin-helsinki,
  -dnk-copenhagen, -nor-oslo, -bel-brussels, -chl-santiago, -col-bogota,
  -cri-san-jose, -bra-sao-paulo, -ury-montevideo, -zaf-cape-town,
  -ecu-quito, -swe-gothenburg, -pry-asuncion for the first twenty-five)
  per ADR-2607141700 (cloud-itonami-compliance-fact-federation).
  Guadalajara is Mexico's second-largest city but NOT its national
  capital (Mexico City is).

  Mexico City (cdmx.gob.mx) was attempted in an earlier tick and
  abandoned when its entire hosting cluster proved unreachable across
  three subdomains on the same IP. Guadalajara's official PDFs
  rendered cleanly instead -- both entries here cite official
  guadalajara.gob.mx-family sources, never fabricated.

  'Código de Gobierno Municipal de Guadalajara': title directly
  confirmed by reading the saved transparencia.guadalajara.gob.mx PDF's
  own cover page. Its own original enactment date was not found on the
  pages read (this is a large, multi-hundred-article code; navigating
  to a possible 'transitorios' section at its end was impractical), so
  :ordinance/enacted-date is deliberately omitted rather than
  attributing an ambiguous amendment-history date found via WebSearch.

  'Reglamento del Ayuntamiento de Guadalajara': title AND approval date
  (2010-01-01) directly confirmed by reading the saved
  imuvigdl.gob.mx-mirrored PDF's own promulgation header. That header
  incidentally named the sitting Presidente Municipal at the time --
  read only to locate the date, never stored in this catalog.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"guadalajara"
   [{:ordinance/id "guadalajara.codigo-gobierno-municipal"
     :ordinance/title "Código de Gobierno Municipal de Guadalajara"
     :ordinance/municipality "guadalajara"
     :ordinance/country "MEX"
     :ordinance/kind :ordinance
     :ordinance/url "https://transparencia.guadalajara.gob.mx/sites/default/files/reglamentos/CodigoGobiernoMunicipalGuadalajara.pdf"
     :ordinance/url-provenance :official-guadalajara-gob-mx
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "guadalajara.reglamento-ayuntamiento"
     :ordinance/title "Reglamento del Ayuntamiento de Guadalajara"
     :ordinance/municipality "guadalajara"
     :ordinance/country "MEX"
     :ordinance/kind :ordinance
     :ordinance/url "http://imuvigdl.gob.mx/descargas/Leyes-y-Reglamentos/4-28-reg.ayuntamientoguadalajara_0.pdf"
     :ordinance/url-provenance :official-guadalajara-gob-mx
     :ordinance/enacted-date "2010-01-01"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}]})

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
      :note (str "cloud-itonami-municipality-mex-guadalajara Wave 0 (ADR-2607141700): "
                 (count (get catalog "guadalajara")) " Guadalajara entries seeded "
                 "with an official guadalajara.gob.mx-family citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
