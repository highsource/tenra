# Converting DB Netz Railway Network into GeoJSON

Tenra converts the railway network data in INSPIRE format into GeoJSON format.

[DB Netz AG](https://fahrweg.dbnetze.com) is the rail infrastructure company
of the [Deutsche Bahn AG](http://www.deutschebahn.com/) (the German Railways)
and is responsible for the approximately 33.000 km long rail network.

Since November 2015 [DB Netz AG](https://fahrweg.dbnetze.com) publishes the
geodata of the railway network in the [DB Open Data Portal](http://data.deutschebahn.com)
under the [Creative Commons Attribution 4.0 International (CC BY 4.0)](https://creativecommons.org/licenses/by/4.0/) license.

The problem is, however, that the INSPIRE format used for this publication is
not completely straightforward and cannot be fully processed by the usual GIS
tools (like [QGIS](http://www.qgis.org/)). As a result, a lot of attributes go
missing in the layers. For instance, railway lines miss the track numbers or
railway station nodes miss the station codes.

The Tenra projects aims to overcome these problems by providing a converter
from the INSPIRE format to the standard [GeoJSON](http://geojson.org/) format
which can be processed by most of the GIS tools out there.

# Usage

* Download and extract [DB_Inspire_XML.zip](http://download-data.deutschebahn.com/static/datasets/streckennetz/) from the [DB Open Data Portal](http://data.deutschebahn.com) [here](http://data.deutschebahn.com/datasets/streckennetz/).
* You'll get an XML file like `DB_Inspire_XML_2015.zip`
* Use `tenra-<VERSION>.jar` to convert the extracted XML file:  
```
java -jar tenra-<VERSION>.jar DB-Netz_INSPIRE_20131128.xml
```
* You'll get the following files ins GeoJSON format (features):
  * `railwayStationNodes.geojson` - Stations/stops
  * `railwayLines.geojson` - Railway lines
  * `markerPosts.geojson` - Kilometer marks
  * `railwayNodes.geojson` - Railway nodes
  * `railwayLinks.geojson` - Railway links
  * `railwayLinkSequences.geojson` - Sequences of railway links

# Licenses

* The original DB Netz INSPIRE dataset is published under the [Creative Commons Attribution 4.0 International (CC BY 4.0)](https://creativecommons.org/licenses/by/4.0/) license
* The resulting files will fall under the same [Creative Commons Attribution 4.0 International (CC BY 4.0)](https://creativecommons.org/licenses/by/4.0/) license
  * Don't forget the attribution:  
  **You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.**
* Tenra (this project) is published under the [MIT License](https://raw.githubusercontent.com/highsource/tenra/master/LICENSE)
