-- -- main
-- TRUNCATE TABLE t_feeds,
-- t_supplies,
-- t_aliments_nutrients,
-- t_aliments,
-- t_fish,
-- t_races_nutrients,
-- t_races,
-- t_aquariums,
-- t_periods,
-- t_nutrients,
-- t_fish_daily_feeds,
-- t_fish_daily_aliments,
-- t_fish_daily_nutrients RESTART IDENTITY CASCADE;
-- INSERT INTO
--     t_periods (name, begin_at, end_at)
-- VALUES
--     ('period 1', '2026-01-01', null);
-- INSERT INTO
--     t_aquariums (name, id_period)
-- VALUES
--     ('aquarium 1', 1),
--     ('aquarium 2', 1);
-- INSERT INTO
--     t_races (
--         name,
--         purchase_price,
--         sale_price,
--         max_weight,
--         increase_capacity
--     )
-- VALUES
--     ('carpe', 10, 20, 5, 0.5),
--     ('thon', 10, 20, 5, 0.5);
-- INSERT INTO
--     t_nutrients (name)
-- VALUES
--     ('proteine'),
--     ('glucide');
-- INSERT INTO
--     t_races_nutrients (need, id_race, id_nutrient)
-- VALUES
--     (0.2, 1, 1),
--     (0.4, 1, 2),
--     (0.3, 2, 1),
--     (0.6, 2, 2);
-- INSERT INTO
--     t_fish (name, initial_weight, id_race, id_aquarium)
-- VALUES
--     ('carpe 1', 0.1, 1, 1),
--     ('carpe 2', 0.6, 1, 1),
--     ('thon 1', 0.1, 2, 1),
--     ('thon 2', 0.1, 2, 2);
-- INSERT INTO
--     t_aliments (name, cost)
-- VALUES
--     ('carotte', 1),
--     ('patate', 2);
-- INSERT INTO
--     t_aliments_nutrients (intake, id_aliment, id_nutrient)
-- VALUES
--     (0.1, 1, 1),
--     (0.1, 1, 2),
--     (0.2, 2, 1),
--     (0.2, 2, 2);
-- INSERT INTO
--     t_supplies (begin_at, end_at, id_aquarium)
-- VALUES
--     ('2026-01-01', '2026-01-01', 1),
--     ('2026-01-02', '2026-01-02', 1),
--     ('2026-01-05', '2026-01-05', 1),
--     ('2026-01-07', '2026-01-07', 1),
--     ('2026-01-06', '2026-01-06', 2);
-- INSERT INTO
--     t_feeds (qtt, id_aliment, id_supply)
-- VALUES
--     (6, 1, 1),
--     (6, 2, 1),
--     (6, 1, 2),
--     (6, 2, 3),
--     (6, 1, 4),
--     (6, 2, 5);
--------------------------------------------------------------------------------------
-- 3 t
-- TRUNCATE TABLE t_feeds,
-- t_supplies,
-- t_aliments_nutrients,
-- t_aliments,
-- t_fish,
-- t_races_nutrients,
-- t_races,
-- t_aquariums,
-- t_periods,
-- t_nutrients,
-- t_fish_daily_feeds,
-- t_fish_daily_aliments,
-- t_fish_daily_nutrients RESTART IDENTITY CASCADE;
-- INSERT INTO
--     t_periods (name, begin_at, end_at)
-- VALUES
--     ('period 1', '2026-01-01', null);
-- INSERT INTO
--     t_aquariums (name, id_period)
-- VALUES
--     ('aquarium 1', 1),
--     ('aquarium 2', 1);
-- INSERT INTO
--     t_races (
--         name,
--         purchase_price,
--         sale_price,
--         max_weight,
--         increase_capacity
--     )
-- VALUES
--     ('carpe', 10, 20, 5, 0.5),
--     ('thon', 10, 20, 5, 0.5);
-- INSERT INTO
--     t_nutrients (name)
-- VALUES
--     ('proteine'),
--     ('glucide'),
--     ('glucose');
-- INSERT INTO
--     t_races_nutrients (need, id_race, id_nutrient)
-- VALUES
--     (0.2, 1, 1),
--     (0.4, 1, 2),
--     (0.6, 1, 3),
--     (0.3, 2, 1),
--     (0.6, 2, 2),
--     (0.6, 2, 3);
-- INSERT INTO
--     t_fish (name, initial_weight, id_race, id_aquarium)
-- VALUES
--     ('carpe 1', 0.1, 1, 1),
--     ('carpe 2', 0.6, 1, 1),
--     ('thon 1', 0.1, 2, 1),
--     ('thon 2', 0.1, 2, 2);
-- INSERT INTO
--     t_aliments (name, cost)
-- VALUES
--     ('carotte', 1),
--     ('patate', 2);
-- INSERT INTO
--     t_aliments_nutrients (intake, id_aliment, id_nutrient)
-- VALUES
--     (0.1, 1, 1),
--     (0.1, 1, 2),
--     (0.2, 2, 1),
--     (0.2, 2, 2);
-- INSERT INTO
--     t_supplies (begin_at, end_at, id_aquarium)
-- VALUES
--     ('2026-01-01', '2026-01-01', 1),
--     ('2026-01-02', '2026-01-02', 1),
--     ('2026-01-05', '2026-01-05', 1),
--     ('2026-01-07', '2026-01-07', 1),
--     ('2026-01-06', '2026-01-06', 2);
-- INSERT INTO
--     t_feeds (qtt, id_aliment, id_supply)
-- VALUES
--     (6, 1, 1),
--     (6, 2, 1),
--     (6, 1, 2),
--     (6, 2, 3),
--     (6, 1, 4),
--     (6, 2, 5);
--------------------------------------------------------------------------------------
-- TRUNCATE TABLE t_feeds,
-- t_supplies,
-- t_aliments_nutrients,
-- t_aliments,
-- t_fish,
-- t_races_nutrients,
-- t_races,
-- t_aquariums,
-- t_periods,
-- t_nutrients,
-- t_fish_daily_feeds,
-- t_fish_daily_aliments,
-- t_fish_daily_nutrients RESTART IDENTITY CASCADE;
-- INSERT INTO
--     t_periods (name, begin_at, end_at)
-- VALUES
--     ('period 1', '2026-01-01', null);
-- INSERT INTO
--     t_aquariums (name, id_period)
-- VALUES
--     ('aquarium 1', 1),
--     ('aquarium 2', 1);
-- INSERT INTO
--     t_races (
--         name,
--         purchase_price,
--         sale_price,
--         max_weight,
--         increase_capacity
--     )
-- VALUES
--     ('carpe', 10, 20, 5, 0.5),
--     ('thon', 10, 20, 5, 0.5);
-- INSERT INTO
--     t_nutrients (name)
-- VALUES
--     ('proteine'),
--     ('glucide');
-- INSERT INTO
--     t_races_nutrients (need, id_race, id_nutrient)
-- VALUES
--     (0.2, 1, 1),
--     (0.4, 1, 2),
--     (0.3, 2, 1),
--     (0.7, 2, 2);
-- INSERT INTO
--     t_fish (name, initial_weight, id_race, id_aquarium)
-- VALUES
--     ('carpe 1', 0.1, 1, 1),
--     ('carpe 2', 0.6, 1, 1),
--     ('thon 1', 0.1, 2, 1),
--     ('thon 2', 0.1, 2, 2);
-- INSERT INTO
--     t_aliments (name, cost)
-- VALUES
--     ('carotte', 1),
--     ('patate', 2);
-- INSERT INTO
--     t_aliments_nutrients (intake, id_aliment, id_nutrient)
-- VALUES
--     (0.1, 1, 1),
--     (0.1, 1, 2),
--     (0.2, 2, 1),
--     (0.2, 2, 2);
-- INSERT INTO
--     t_supplies (begin_at, end_at, id_aquarium)
-- VALUES
--     ('2026-01-01', '2026-01-01', 1),
--     ('2026-01-02', '2026-01-02', 1),
--     ('2026-01-05', '2026-01-05', 1),
--     ('2026-01-07', '2026-01-07', 1),
--     ('2026-01-06', '2026-01-06', 2);
-- INSERT INTO
--     t_feeds (qtt, id_aliment, id_supply)
-- VALUES
--     (6, 1, 1),
--     (6, 2, 1),
--     (6, 1, 2),
--     (6, 2, 3),
--     (6, 1, 4),
--     (6, 2, 5);
--------------------------------------------------------------------------------------
-- unique simple
TRUNCATE TABLE t_feeds,
t_supplies,
t_aliments_nutrients,
t_aliments,
t_fish,
t_races_nutrients,
t_races,
t_aquariums,
t_periods,
t_nutrients,
t_fish_daily_feeds,
t_fish_daily_aliments,
t_fish_daily_nutrients RESTART IDENTITY CASCADE;

INSERT INTO
    t_periods (name, begin_at, end_at)
VALUES
    ('period 1', '2026-01-01', null);

INSERT INTO
    t_aquariums (name, id_period)
VALUES
    ('aquarium 1', 1);

INSERT INTO
    t_races (
        name,
        purchase_price,
        sale_price,
        max_weight,
        increase_capacity
    )
VALUES
    ('carpe', 10, 20, 5, 0.5);

INSERT INTO
    t_nutrients (name)
VALUES
    ('proteine'),
    ('glucide');

INSERT INTO
    t_races_nutrients (need, id_race, id_nutrient)
VALUES
    (0.2, 1, 1),
    (0.4, 1, 2);

INSERT INTO
    t_fish (name, initial_weight, id_race, id_aquarium)
VALUES
    ('carpe 1', 0.1, 1, 1);

INSERT INTO
    t_aliments (name, cost)
VALUES
    ('carotte', 1),
    ('patate', 2);

INSERT INTO
    t_aliments_nutrients (intake, id_aliment, id_nutrient)
VALUES
    (0.1, 1, 1),
    (0.1, 1, 2),
    (0.2, 2, 1),
    (0.2, 2, 2);

INSERT INTO
    t_supplies (begin_at, end_at, id_aquarium)
VALUES
    ('2026-01-01', '2026-01-01', 1),
    ('2026-01-02', '2026-01-02', 1),
    ('2026-01-05', '2026-01-05', 1),
    ('2026-01-07', '2026-01-07', 1);

INSERT INTO
    t_feeds (qtt, id_aliment, id_supply)
VALUES
    (6, 1, 1),
    (6, 2, 1),
    (6, 1, 2),
    (6, 2, 3),
    (6, 1, 4);