# cloud-itonami-municipality-mex-guadalajara

Municipal-ordinance compliance catalog for **Guadalajara** (Jalisco,
Mexico) — the TWENTY-SIXTH municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc),
[`cloud-itonami-municipality-gbr-london`](https://github.com/cloud-itonami/cloud-itonami-municipality-gbr-london),
[`cloud-itonami-municipality-can-toronto`](https://github.com/cloud-itonami/cloud-itonami-municipality-can-toronto),
[`cloud-itonami-municipality-deu-berlin`](https://github.com/cloud-itonami/cloud-itonami-municipality-deu-berlin),
[`cloud-itonami-municipality-fra-paris`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-paris),
[`cloud-itonami-municipality-nld-amsterdam`](https://github.com/cloud-itonami/cloud-itonami-municipality-nld-amsterdam),
[`cloud-itonami-municipality-esp-madrid`](https://github.com/cloud-itonami/cloud-itonami-municipality-esp-madrid),
[`cloud-itonami-municipality-kor-seoul`](https://github.com/cloud-itonami/cloud-itonami-municipality-kor-seoul),
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma),
[`cloud-itonami-municipality-aus-sydney`](https://github.com/cloud-itonami/cloud-itonami-municipality-aus-sydney),
[`cloud-itonami-municipality-arg-buenos-aires`](https://github.com/cloud-itonami/cloud-itonami-municipality-arg-buenos-aires),
[`cloud-itonami-municipality-fin-helsinki`](https://github.com/cloud-itonami/cloud-itonami-municipality-fin-helsinki),
[`cloud-itonami-municipality-dnk-copenhagen`](https://github.com/cloud-itonami/cloud-itonami-municipality-dnk-copenhagen),
[`cloud-itonami-municipality-nor-oslo`](https://github.com/cloud-itonami/cloud-itonami-municipality-nor-oslo),
[`cloud-itonami-municipality-bel-brussels`](https://github.com/cloud-itonami/cloud-itonami-municipality-bel-brussels),
[`cloud-itonami-municipality-chl-santiago`](https://github.com/cloud-itonami/cloud-itonami-municipality-chl-santiago),
[`cloud-itonami-municipality-col-bogota`](https://github.com/cloud-itonami/cloud-itonami-municipality-col-bogota),
[`cloud-itonami-municipality-cri-san-jose`](https://github.com/cloud-itonami/cloud-itonami-municipality-cri-san-jose),
[`cloud-itonami-municipality-bra-sao-paulo`](https://github.com/cloud-itonami/cloud-itonami-municipality-bra-sao-paulo),
[`cloud-itonami-municipality-ury-montevideo`](https://github.com/cloud-itonami/cloud-itonami-municipality-ury-montevideo),
[`cloud-itonami-municipality-zaf-cape-town`](https://github.com/cloud-itonami/cloud-itonami-municipality-zaf-cape-town),
[`cloud-itonami-municipality-ecu-quito`](https://github.com/cloud-itonami/cloud-itonami-municipality-ecu-quito),
[`cloud-itonami-municipality-swe-gothenburg`](https://github.com/cloud-itonami/cloud-itonami-municipality-swe-gothenburg),
and
[`cloud-itonami-municipality-pry-asuncion`](https://github.com/cloud-itonami/cloud-itonami-municipality-pry-asuncion).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Mexico's national capital is Mexico City, not Guadalajara — Mexico City
(`cdmx.gob.mx`) was attempted in an earlier tick and abandoned when its
entire hosting cluster proved unreachable across three subdomains.
Guadalajara's official PDFs rendered cleanly instead.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the City of
Guadalajara's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries cite official guadalajara.gob.mx-family PDFs: the
**Código de Gobierno Municipal de Guadalajara** (title directly
confirmed; its own original enactment date not found on the pages
read, so `:ordinance/enacted-date` is deliberately omitted) and the
**Reglamento del Ayuntamiento de Guadalajara** (title and approval
date, 2010-01-01, both directly confirmed via the document's own
promulgation header — a personal name incidentally appearing in that
header was read only to locate the date and never stored).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the City of Guadalajara's; this repo stores only
citation metadata (id/title/url/dates), not full text.
