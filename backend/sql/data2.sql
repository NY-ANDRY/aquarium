TRUNCATE TABLE t_feeds,
t_supplies,
t_aliments_nutrients,
t_aliments,
t_fish,
t_species_nutrients,
t_species,
t_aquariums,
t_periods,
t_nutrients,
t_fish_daily_feeds,
t_fish_daily_aliments,
t_fish_daily_nutrients RESTART IDENTITY CASCADE;

INSERT INTO
    t_periods (name, begin_at, end_at)
VALUES
    ('period 1', '2026-02-01', null);

INSERT INTO
    t_aquariums (name, id_period)
VALUES
    ('aquarium 1', 1);

INSERT INTO
    t_species (
        name,
        purchase_price,
        sale_price,
        max_weight,
        increase_capacity
    )
VALUES
    ('tilapia', 1000, 5000, 1.5, 0.01),
    ('carpe', 1200, 6000, 2, 0.012);

INSERT INTO
    t_nutrients (name)
VALUES
    ('proteine'),
    ('glucide');

INSERT INTO
    t_species_nutrients (need, id_species, id_nutrient)
VALUES
    (0.004, 1, 1),
    (0.002, 1, 2),
    (0.010, 2, 1),
    (0.005, 2, 2);

INSERT INTO
    t_fish (name, initial_weight, id_species, id_aquarium)
VALUES
    ('tilapia 1', 0.005, 1, 1),
    ('tilapia 2', 0.0055, 1, 1),
    ('carpe 1', 0.006, 2, 1),
    ('carpe 2', 0.0065, 2, 1);

INSERT INTO
    t_aliments (name, cost)
VALUES
    ('carotte', 1000),
    ('patate', 2000);

INSERT INTO
    t_aliments_nutrients (intake, id_aliment, id_nutrient)
VALUES
    (0.1, 1, 1),
    (0.1, 1, 2),
    (0.02, 2, 1),
    (0.01, 2, 2);

INSERT INTO
    t_supplies (begin_at, end_at, id_aquarium)
VALUES
    ('2026-02-01', '2026-02-01', 1),
    ('2026-02-02', '2026-02-02', 1);

INSERT INTO
    t_feeds (qtt, id_aliment, id_supply)
VALUES
    (5, 1, 1),
    (5, 2, 1),
    (10, 2, 2);