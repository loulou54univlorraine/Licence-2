awk 'BEGIN{}
{
if ($1 == "address") {printf("Taille memoire physique %d , memoire virtuelle %d. \n", $4,$7) };
}
END{}' /proc/cpuinfo

awk 'BEGIN{}
{
if ($1 == "MemTotal:") {printf("Taille totale memoire %d Ko", $2) };
if ($1 == "MemFree:") {printf(", libre %d Ko", $2) };
if ($1 == "PageTables:") {printf(", taille des tables %d Ko. \n", $2) };
}
END{}' /proc/meminfo