#!/bin/bash

output_file="sql/base.txt"
tables=(
"t_aliments" 
"t_aliments_nutrients" 
"t_aquariums" 
"t_cash_flows"
"t_feeds"
"t_fish"
"t_fish_daily_feeds"
"t_fish_daily_nutrients"
"t_flows"
"t_nutrients"
"t_periods"
"t_species"
"t_species_nutrients" 
"t_supplies"
)

echo "tables structure" > "$output_file"
echo "" >> "$output_file"

for table in "${tables[@]}"; do
    echo "$table" >> "$output_file"
    sudo psql -U abc -d aquarium -t -A -c "\d $table" | sudo tee -a "$output_file" > /dev/null
    echo "" >> "$output_file"
done
