package org.data.database;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.interfaces.SimpleLocatable;
import simple.robot.utils.WorldArea;

public class Areas {

    public enum Home {
        BANK_AREA(new WorldArea(new WorldPoint(1944, 3271, 0), new WorldPoint(1962, 3286, 0))),
        AFK_AREA(new WorldArea(new WorldPoint(1977, 3295, 0), new WorldPoint(1994, 3312, 0))),
        REGEN_AREA(new WorldArea(new WorldPoint(1936, 3278, 0), new WorldPoint(1948, 3293, 0))),
        TASK_AREA(new WorldArea(new WorldPoint(1969, 3303, 0), new WorldPoint(1978, 3313, 0)));

        WorldArea area;
        Home(WorldArea Area) {area = Area;}

        public WorldArea get() {return area;}
        public boolean contains(WorldPoint point) {
            return area.containsPoint(point);
        }
    }

    public static class Cities {
        public enum Ardougne {
            BOUNDS(new WorldArea(
                    new WorldPoint(2559, 3263, 0), new WorldPoint(2559, 3337, 0), new WorldPoint(2564, 3342, 0),
                    new WorldPoint(2615, 3342, 0), new WorldPoint(2617, 3340, 0), new WorldPoint(2668, 3340, 0),
                    new WorldPoint(2674, 3334, 0), new WorldPoint(2682, 3334, 0), new WorldPoint(2688, 3328, 0),
                    new WorldPoint(2688, 3314, 0), new WorldPoint(2687, 3313, 0), new WorldPoint(2687, 3312, 0),
                    new WorldPoint(2688, 3311, 0), new WorldPoint(2688, 3299, 0), new WorldPoint(2686, 3297, 0),
                    new WorldPoint(2686, 3290, 0), new WorldPoint(2688, 3288, 0), new WorldPoint(2688, 3280, 0),
                    new WorldPoint(2689, 3277, 0), new WorldPoint(2689, 3273, 0), new WorldPoint(2663, 3262, 0),
                    new WorldPoint(2637, 3263, 0), new WorldPoint(2626, 3263, 0), new WorldPoint(2625, 3264, 0),
                    new WorldPoint(2612, 3264, 0), new WorldPoint(2611, 3263, 0), new WorldPoint(2611, 3258, 0),
                    new WorldPoint(2610, 3257, 0), new WorldPoint(2603, 3257, 0), new WorldPoint(2602, 3258, 0),
                    new WorldPoint(2602, 3263, 0)
            )),
            CENTRE(new WorldArea(
                    new WorldPoint(2651, 3294, 0), new WorldPoint(2675, 3320, 0)
            )),
            MILL(new WorldArea(
                    new WorldPoint(2632, 3381, 0), new WorldPoint(2634, 3381, 0), new WorldPoint(2637, 3385, 0),
                    new WorldPoint(2637, 3387, 0), new WorldPoint(2634, 3390, 0), new WorldPoint(2632, 3390, 0),
                    new WorldPoint(2629, 3387, 0), new WorldPoint(2629, 3385, 0)
            )),
            FARMING_PATCH(new WorldArea(
                    new WorldPoint(2660, 3368, 0), new WorldPoint(2673, 3381, 0)
            ));

            WorldArea area;

            Ardougne(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }

            public boolean containsIgnorePlane(WorldPoint point) {
                return area.containsPoint(point, true);
            }
        }

        public enum Varrock {
            BOUNDS(new WorldArea(
                    new WorldPoint(3133, 3521, 0), new WorldPoint(3131, 3513, 0), new WorldPoint(3127, 3505, 0),
                    new WorldPoint(3122, 3497, 0), new WorldPoint(3110, 3490, 0), new WorldPoint(3102, 3469, 0),
                    new WorldPoint(3104, 3443, 0), new WorldPoint(3113, 3433, 0), new WorldPoint(3105, 3424, 0),
                    new WorldPoint(3105, 3418, 0), new WorldPoint(3111, 3405, 0), new WorldPoint(3112, 3397, 0),
                    new WorldPoint(3122, 3389, 0), new WorldPoint(3141, 3387, 0), new WorldPoint(3151, 3368, 0),
                    new WorldPoint(3155, 3353, 0), new WorldPoint(3188, 3345, 0), new WorldPoint(3207, 3334, 0),
                    new WorldPoint(3224, 3334, 0), new WorldPoint(3227, 3331, 0), new WorldPoint(3234, 3331, 0),
                    new WorldPoint(3238, 3335, 0), new WorldPoint(3248, 3335, 0), new WorldPoint(3250, 3333, 0),
                    new WorldPoint(3250, 3332, 0), new WorldPoint(3251, 3331, 0), new WorldPoint(3253, 3330, 0),
                    new WorldPoint(3300, 3330, 0), new WorldPoint(3301, 3331, 0), new WorldPoint(3304, 3331, 0),
                    new WorldPoint(3305, 3330, 0), new WorldPoint(3307, 3330, 0), new WorldPoint(3308, 3329, 0),
                    new WorldPoint(3312, 3329, 0), new WorldPoint(3312, 3352, 0), new WorldPoint(3313, 3353, 0),
                    new WorldPoint(3313, 3355, 0), new WorldPoint(3312, 3356, 0), new WorldPoint(3312, 3359, 0),
                    new WorldPoint(3311, 3360, 0), new WorldPoint(3305, 3360, 0), new WorldPoint(3304, 3361, 0),
                    new WorldPoint(3304, 3362, 0), new WorldPoint(3305, 3363, 0), new WorldPoint(3305, 3365, 0),
                    new WorldPoint(3304, 3366, 0), new WorldPoint(3304, 3383, 0), new WorldPoint(3303, 3384, 0),
                    new WorldPoint(3297, 3384, 0), new WorldPoint(3296, 3385, 0), new WorldPoint(3296, 3437, 0),
                    new WorldPoint(3297, 3438, 0), new WorldPoint(3297, 3440, 0), new WorldPoint(3296, 3441, 0),
                    new WorldPoint(3296, 3448, 0), new WorldPoint(3297, 3449, 0), new WorldPoint(3297, 3451, 0),
                    new WorldPoint(3296, 3452, 0), new WorldPoint(3296, 3455, 0), new WorldPoint(3297, 3456, 0),
                    new WorldPoint(3312, 3456, 0), new WorldPoint(3312, 3458, 0), new WorldPoint(3313, 3459, 0),
                    new WorldPoint(3313, 3461, 0), new WorldPoint(3316, 3464, 0), new WorldPoint(3318, 3464, 0),
                    new WorldPoint(3320, 3466, 0), new WorldPoint(3320, 3469, 0), new WorldPoint(3318, 3472, 0),
                    new WorldPoint(3315, 3472, 0), new WorldPoint(3312, 3474, 0), new WorldPoint(3312, 3477, 0),
                    new WorldPoint(3313, 3478, 0), new WorldPoint(3313, 3480, 0), new WorldPoint(3311, 3484, 0),
                    new WorldPoint(3311, 3487, 0), new WorldPoint(3312, 3488, 0), new WorldPoint(3316, 3488, 0),
                    new WorldPoint(3317, 3487, 0), new WorldPoint(3320, 3487, 0), new WorldPoint(3321, 3488, 0),
                    new WorldPoint(3327, 3488, 0), new WorldPoint(3328, 3489, 0), new WorldPoint(3328, 3522, 0)
            )),
            RUNE_STORE(new WorldArea(
                    new WorldPoint(3252, 3399, 0), new WorldPoint(3250, 3401, 0), new WorldPoint(3250, 3403, 0),
                    new WorldPoint(3252, 3403, 0), new WorldPoint(3252, 3405, 0), new WorldPoint(3254, 3405, 0),
                    new WorldPoint(3256, 3403, 0), new WorldPoint(3256, 3401, 0), new WorldPoint(3254, 3399, 0)
            ));
            WorldArea area;

            Varrock(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Seers {
            BOUNDS(new WorldArea(
                    new WorldPoint(2679, 3513, 0), new WorldPoint(2708, 3520, 0), new WorldPoint(2787, 3519, 0),
                    new WorldPoint(2774, 3461, 0), new WorldPoint(2752, 3452, 0), new WorldPoint(2752, 3437, 0),
                    new WorldPoint(2746, 3436, 0), new WorldPoint(2739, 3436, 0), new WorldPoint(2681, 3457, 0)
            )),
            TP_SPOT(new WorldArea(
                    new WorldPoint(2721, 3483, 0), new WorldPoint(2732, 3488, 0)
            )),
            FLAX_FIELD(new WorldArea(
                    new WorldPoint(2752, 3452, 0), new WorldPoint(2752, 3437, 0), new WorldPoint(2747, 3437, 0),
                    new WorldPoint(2746, 3436, 0), new WorldPoint(2742, 3436, 0), new WorldPoint(2741, 3437, 0),
                    new WorldPoint(2739, 3437, 0), new WorldPoint(2737, 3439, 0), new WorldPoint(2737, 3445, 0),
                    new WorldPoint(2736, 3446, 0), new WorldPoint(2736, 3450, 0), new WorldPoint(2738, 3452, 0),
                    new WorldPoint(2739, 3452, 0), new WorldPoint(2741, 3454, 0), new WorldPoint(2743, 3454, 0),
                    new WorldPoint(2744, 3453, 0), new WorldPoint(2745, 3453, 0), new WorldPoint(2746, 3452, 0)
            )),
            MCGRUBORS_WOOD(new WorldArea(
                    new WorldPoint(2624, 3507, 0), new WorldPoint(2624, 3470, 0), new WorldPoint(2629, 3470, 0),
                    new WorldPoint(2631, 3468, 0), new WorldPoint(2641, 3468, 0), new WorldPoint(2642, 3469, 0),
                    new WorldPoint(2646, 3469, 0), new WorldPoint(2648, 3470, 0), new WorldPoint(2656, 3470, 0),
                    new WorldPoint(2657, 3469, 0), new WorldPoint(2661, 3469, 0), new WorldPoint(2663, 3467, 0),
                    new WorldPoint(2669, 3467, 0), new WorldPoint(2671, 3469, 0), new WorldPoint(2671, 3478, 0),
                    new WorldPoint(2677, 3484, 0), new WorldPoint(2677, 3488, 0), new WorldPoint(2680, 3491, 0),
                    new WorldPoint(2680, 3493, 0), new WorldPoint(2679, 3494, 0), new WorldPoint(2679, 3497, 0),
                    new WorldPoint(2677, 3499, 0), new WorldPoint(2677, 3504, 0), new WorldPoint(2673, 3508, 0),
                    new WorldPoint(2667, 3508, 0), new WorldPoint(2665, 3506, 0), new WorldPoint(2665, 3505, 0),
                    new WorldPoint(2662, 3502, 0), new WorldPoint(2662, 3492, 0), new WorldPoint(2659, 3489, 0),
                    new WorldPoint(2657, 3489, 0), new WorldPoint(2654, 3492, 0), new WorldPoint(2654, 3502, 0),
                    new WorldPoint(2653, 3503, 0), new WorldPoint(2653, 3504, 0), new WorldPoint(2649, 3508, 0),
                    new WorldPoint(2637, 3508, 0), new WorldPoint(2636, 3509, 0), new WorldPoint(2629, 3509, 0),
                    new WorldPoint(2628, 3508, 0), new WorldPoint(2624, 3508, 0)
            )),
            KNIGHTS_HOUSE(new WorldArea(
                    new WorldPoint(2607, 3472, 0), new WorldPoint(2618, 3486, 0)
            ));

            WorldArea area;

            Seers(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Rimmington {
            BOUNDS(new WorldArea(
                    new WorldPoint(2981, 3192, 0), new WorldPoint(2995, 3192, 0), new WorldPoint(2995, 3268, 0),
                    new WorldPoint(2907, 3267, 0), new WorldPoint(2907, 3208, 0), new WorldPoint(2968, 3185, 0)
            )),
            MINE(new WorldArea(
                    new WorldPoint(2970, 3229, 0), new WorldPoint(2970, 3231, 0), new WorldPoint(2969, 3232, 0),
                    new WorldPoint(2968, 3232, 0), new WorldPoint(2965, 3235, 0), new WorldPoint(2965, 3236, 0),
                    new WorldPoint(2964, 3237, 0), new WorldPoint(2964, 3242, 0), new WorldPoint(2965, 3243, 0),
                    new WorldPoint(2965, 3244, 0), new WorldPoint(2966, 3245, 0), new WorldPoint(2966, 3246, 0),
                    new WorldPoint(2967, 3247, 0), new WorldPoint(2968, 3247, 0), new WorldPoint(2970, 3249, 0),
                    new WorldPoint(2970, 3250, 0), new WorldPoint(2971, 3251, 0), new WorldPoint(2972, 3251, 0),
                    new WorldPoint(2973, 3252, 0), new WorldPoint(2984, 3252, 0), new WorldPoint(2988, 3248, 0),
                    new WorldPoint(2988, 3247, 0), new WorldPoint(2989, 3246, 0), new WorldPoint(2990, 3246, 0),
                    new WorldPoint(2991, 3245, 0), new WorldPoint(2991, 3238, 0), new WorldPoint(2990, 3237, 0),
                    new WorldPoint(2990, 3234, 0), new WorldPoint(2989, 3233, 0), new WorldPoint(2989, 3232, 0),
                    new WorldPoint(2988, 3231, 0), new WorldPoint(2988, 3230, 0), new WorldPoint(2986, 3228, 0),
                    new WorldPoint(2985, 3228, 0), new WorldPoint(2984, 3227, 0), new WorldPoint(2977, 3227, 0),
                    new WorldPoint(2976, 3228, 0), new WorldPoint(2975, 3228, 0), new WorldPoint(2974, 3229, 0)
            ));

            WorldArea area;

            Rimmington(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Catherby {
            BOUNDS(new WorldArea(
                    new WorldPoint(2792, 3458, 0), new WorldPoint(2805, 3472, 0), new WorldPoint(2823, 3475, 0),
                    new WorldPoint(2841, 3456, 0), new WorldPoint(2859, 3438, 0), new WorldPoint(2869, 3429, 0),
                    new WorldPoint(2864, 3420, 0), new WorldPoint(2851, 3413, 0), new WorldPoint(2839, 3412, 0),
                    new WorldPoint(2803, 3408, 0), new WorldPoint(2767, 3421, 0), new WorldPoint(2752, 3437, 0),
                    new WorldPoint(2752, 3452, 0)
            )),
            BEEHIVE(new WorldArea(
                    new WorldPoint(2752, 3437, 0), new WorldPoint(2752, 3452, 0), new WorldPoint(2755, 3452, 0),
                    new WorldPoint(2756, 3451, 0), new WorldPoint(2761, 3451, 0), new WorldPoint(2762, 3452, 0),
                    new WorldPoint(2764, 3452, 0), new WorldPoint(2767, 3449, 0), new WorldPoint(2767, 3439, 0),
                    new WorldPoint(2765, 3437, 0), new WorldPoint(2760, 3437, 0), new WorldPoint(2759, 3436, 0),
                    new WorldPoint(2756, 3436, 0), new WorldPoint(2755, 3437, 0)
            ));

            WorldArea area;

            Catherby(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Falador {
            BOUNDS(new WorldArea(
                    new WorldPoint(2940, 3320, 0), new WorldPoint(2936, 3320, 0), new WorldPoint(2936, 3388, 0),
                    new WorldPoint(2941, 3393, 0), new WorldPoint(2943, 3393, 0), new WorldPoint(2945, 3395, 0),
                    new WorldPoint(2949, 3395, 0), new WorldPoint(2950, 3394, 0), new WorldPoint(2956, 3394, 0),
                    new WorldPoint(2957, 3395, 0), new WorldPoint(2984, 3395, 0), new WorldPoint(2987, 3393, 0),
                    new WorldPoint(2996, 3393, 0), new WorldPoint(2997, 3394, 0), new WorldPoint(3001, 3394, 0),
                    new WorldPoint(3003, 3395, 0), new WorldPoint(3008, 3395, 0), new WorldPoint(3011, 3392, 0),
                    new WorldPoint(3020, 3392, 0), new WorldPoint(3022, 3390, 0), new WorldPoint(3040, 3390, 0),
                    new WorldPoint(3041, 3389, 0), new WorldPoint(3047, 3389, 0), new WorldPoint(3048, 3390, 0),
                    new WorldPoint(3061, 3390, 0), new WorldPoint(3066, 3385, 0), new WorldPoint(3066, 3369, 0),
                    new WorldPoint(3060, 3363, 0), new WorldPoint(3060, 3331, 0), new WorldPoint(3061, 3330, 0),
                    new WorldPoint(3061, 3329, 0), new WorldPoint(3060, 3328, 0), new WorldPoint(3059, 3328, 0),
                    new WorldPoint(3058, 3329, 0), new WorldPoint(3025, 3329, 0), new WorldPoint(3023, 3327, 0),
                    new WorldPoint(3016, 3327, 0), new WorldPoint(3012, 3323, 0), new WorldPoint(3002, 3323, 0),
                    new WorldPoint(2995, 3316, 0), new WorldPoint(2992, 3316, 0), new WorldPoint(2985, 3309, 0),
                    new WorldPoint(2967, 3309, 0), new WorldPoint(2966, 3310, 0), new WorldPoint(2957, 3310, 0),
                    new WorldPoint(2956, 3311, 0), new WorldPoint(2942, 3311, 0), new WorldPoint(2940, 3313, 0)
            )),
            BARBER_SHOP(new WorldArea(
                    new WorldPoint(2949, 3381, 0), new WorldPoint(2948, 3382, 0), new WorldPoint(2946, 3382, 0),
                    new WorldPoint(2946, 3389, 0), new WorldPoint(2944, 3389, 0), new WorldPoint(2944, 3387, 0),
                    new WorldPoint(2942, 3387, 0), new WorldPoint(2942, 3378, 0), new WorldPoint(2943, 3377, 0),
                    new WorldPoint(2948, 3377, 0), new WorldPoint(2949, 3378, 0)
            )),
            ALLOTMENTS(new WorldArea(
                    new WorldPoint(3044, 3300, 0), new WorldPoint(3067, 3315, 0)
            )),
            PARTY_ROOM(new WorldArea(
                    new WorldPoint(3041, 3372, 0), new WorldPoint(3040, 3371, 0), new WorldPoint(3037, 3371, 0),
                    new WorldPoint(3036, 3372, 0), new WorldPoint(3036, 3375, 0), new WorldPoint(3037, 3376, 0),
                    new WorldPoint(3037, 3381, 0), new WorldPoint(3036, 3382, 0), new WorldPoint(3036, 3385, 0),
                    new WorldPoint(3037, 3386, 0), new WorldPoint(3040, 3386, 0), new WorldPoint(3041, 3385, 0),
                    new WorldPoint(3051, 3385, 0), new WorldPoint(3052, 3386, 0), new WorldPoint(3055, 3386, 0),
                    new WorldPoint(3056, 3385, 0), new WorldPoint(3056, 3382, 0), new WorldPoint(3055, 3381, 0),
                    new WorldPoint(3055, 3376, 0), new WorldPoint(3056, 3375, 0), new WorldPoint(3056, 3372, 0),
                    new WorldPoint(3055, 3371, 0), new WorldPoint(3052, 3371, 0), new WorldPoint(3051, 3372, 0)
            )),
            EAST_BANK(null),
            WEST_BANK(new WorldArea(
                    new WorldPoint(2948, 3374, 0), new WorldPoint(2943, 3374, 0), new WorldPoint(2943, 3368, 0),
                    new WorldPoint(2945, 3368, 0), new WorldPoint(2945, 3367, 0), new WorldPoint(2950, 3367, 0),
                    new WorldPoint(2950, 3370, 0), new WorldPoint(2948, 3370, 0)
            )),
            GENERAL_STORE(new WorldArea(
                    new WorldPoint(2961, 3391, 0), new WorldPoint(2953, 3391, 0), new WorldPoint(2953, 3388, 0),
                    new WorldPoint(2956, 3388, 0), new WorldPoint(2956, 3385, 0), new WorldPoint(2961, 3385, 0)
            )),
            CENTRE(new WorldArea(new WorldPoint(2961,3378, 0), new WorldPoint(2971,3388, 0)));

            WorldArea area;

            Falador(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Lumbridge {
            COURTYARD(new WorldArea(new WorldPoint(3216, 3209, 0), new WorldPoint(3227, 3228, 0))),
            FOREST(new WorldArea(new WorldPoint(3160, 3214, 0), new WorldPoint(0, 0, 0))),
            HAM_ENTRANCE(new WorldArea(new WorldPoint(3161, 3245, 0), new WorldPoint(3168, 3253, 0)));

            WorldArea area;

            Lumbridge(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Vyre {
            PUB(new WorldArea(new WorldPoint(3593, 3386, 0), new WorldPoint(3606, 3397, 0)));

            WorldArea area;
            Vyre(WorldArea Area) {area = Area;}

            public WorldArea get() {return area;}
            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum AlKharid {
            OUTSIDE_BANK(new WorldArea(new WorldPoint(3272, 3160, 0), new WorldPoint(3280, 3172, 0))),
            PALACE(new WorldArea(new WorldPoint(3282, 3159, 0), new WorldPoint(3304, 3178, 0))),
            TANNER(new WorldArea(new WorldPoint(3270, 3189, 0), new WorldPoint(3278, 3194, 0))),
            MINE(new WorldArea(
                    new WorldPoint(3290, 3271, 0), new WorldPoint(3307, 3271, 0), new WorldPoint(3306, 3278, 0),
                    new WorldPoint(3308, 3282, 0), new WorldPoint(3303, 3288, 0), new WorldPoint(3307, 3293, 0),
                    new WorldPoint(3304, 3298, 0), new WorldPoint(3308, 3304, 0), new WorldPoint(3304, 3307, 0),
                    new WorldPoint(3306, 3312, 0), new WorldPoint(3303, 3318, 0), new WorldPoint(3301, 3320, 0),
                    new WorldPoint(3297, 3319, 0), new WorldPoint(3295, 3315, 0), new WorldPoint(3295, 3313, 0),
                    new WorldPoint(3293, 3310, 0), new WorldPoint(3295, 3308, 0), new WorldPoint(3293, 3302, 0),
                    new WorldPoint(3290, 3300, 0), new WorldPoint(3293, 3291, 0), new WorldPoint(3291, 3284, 0),
                    new WorldPoint(3291, 3282, 0), new WorldPoint(3293, 3280, 0), new WorldPoint(3291, 3276, 0)
            ));

            WorldArea area;

            AlKharid(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Draynor {
            BOUNDS(new WorldArea(
                    new WorldPoint(3136, 3234, 0), new WorldPoint(3103, 3223, 0), new WorldPoint(3081, 3226, 0),
                    new WorldPoint(3065, 3250, 0), new WorldPoint(3065, 3254, 0), new WorldPoint(3068, 3257, 0),
                    new WorldPoint(3068, 3267, 0), new WorldPoint(3069, 3268, 0), new WorldPoint(3069, 3272, 0),
                    new WorldPoint(3070, 3273, 0), new WorldPoint(3070, 3285, 0), new WorldPoint(3069, 3286, 0),
                    new WorldPoint(3069, 3296, 0), new WorldPoint(3068, 3297, 0), new WorldPoint(3068, 3307, 0),
                    new WorldPoint(3136, 3305, 0)
            )),
            AGGIES_HOUSE(new WorldArea(
                    new WorldPoint(3083, 3256, 0), new WorldPoint(3088, 3261, 0)
            )),
            TP_LOC(new WorldArea(
                    new WorldPoint(3087, 3245, 0), new WorldPoint(3098, 3250, 0)
            )),
            MARKET(new WorldArea(
                    new WorldPoint(3089, 3251, 0), new WorldPoint(3089, 3247, 0), new WorldPoint(3088, 3247, 0),
                    new WorldPoint(3088, 3245, 0), new WorldPoint(3068, 3245, 0), new WorldPoint(3065, 3250, 0),
                    new WorldPoint(3065, 3254, 0), new WorldPoint(3068, 3257, 0), new WorldPoint(3068, 3263, 0),
                    new WorldPoint(3083, 3263, 0), new WorldPoint(3083, 3256, 0), new WorldPoint(3087, 3256, 0),
                    new WorldPoint(3087, 3251, 0)
            )),
            BANK(new WorldArea(
                    new WorldPoint(3088, 3240, 0), new WorldPoint(3097, 3246, 0)
            ));

            WorldArea area;
            Draynor(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Taverley {
            BOUNDS(new WorldArea(new WorldPoint(2877, 3405, 0), new WorldPoint(2943, 3491, 0))),
            SWORD_SHOP(new WorldArea(
                    new WorldPoint(2882, 3451, 0),
                    new WorldPoint(2882, 3449, 0),
                    new WorldPoint(2884, 3447, 0),
                    new WorldPoint(2886, 3447, 0),
                    new WorldPoint(2888, 3449, 0),
                    new WorldPoint(2888, 3451, 0),
                    new WorldPoint(2886, 3453, 0)));

            WorldArea area;

            Taverley(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Yanille {
            BOUNDS(new WorldArea(new WorldPoint(2532, 3073, 0), new WorldPoint(2621, 3110, 0))),
            HUNTER_SHOP(new WorldArea(new WorldPoint(2564, 3079, 0), new WorldPoint(2570, 3085, 0))),
            TELEPORT_LOC(new WorldArea(new WorldPoint(2603, 3087, 0), new WorldPoint(2609, 3098, 0)));

            WorldArea area;

            Yanille(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Brimhaven {
            BOUNDS(new WorldArea(
                    new WorldPoint(2816, 3201, 0), new WorldPoint(2816, 3143, 0), new WorldPoint(2730, 3136, 0),
                    new WorldPoint(2700, 3152, 0), new WorldPoint(2706, 3216, 0), new WorldPoint(2749, 3257, 0)
            ));

            WorldArea area;

            Brimhaven(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Burthorpe {
            BOUNDS(new WorldArea(
                    new WorldPoint(2881, 3525, 0), new WorldPoint(2876, 3529, 0), new WorldPoint(2876, 3539, 0),
                    new WorldPoint(2877, 3540, 0), new WorldPoint(2877, 3541, 0), new WorldPoint(2876, 3542, 0),
                    new WorldPoint(2876, 3544, 0), new WorldPoint(2877, 3545, 0), new WorldPoint(2877, 3548, 0),
                    new WorldPoint(2876, 3549, 0), new WorldPoint(2876, 3551, 0), new WorldPoint(2877, 3552, 0),
                    new WorldPoint(2877, 3553, 0), new WorldPoint(2876, 3554, 0), new WorldPoint(2876, 3575, 0),
                    new WorldPoint(2886, 3583, 0), new WorldPoint(2938, 3583, 0), new WorldPoint(2938, 3525, 0)
            )),
            DUNSTAN_HOUSE(new WorldArea(
                    new WorldPoint(2917, 3572, 0), new WorldPoint(2923, 3577, 0)
            ));

            WorldArea area;

            Burthorpe(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Tzhaar {
            BOUNDS(new WorldArea(
                    new WorldPoint(2506, 5053, 0), new WorldPoint(2544, 5073, 0), new WorldPoint(2562, 5134, 0),
                    new WorldPoint(2525, 5176, 0), new WorldPoint(2471, 5187, 0), new WorldPoint(2385, 5187, 0),
                    new WorldPoint(2369, 5150, 0), new WorldPoint(2377, 5126, 0), new WorldPoint(2427, 5119, 0),
                    new WorldPoint(2455, 5078, 0)
            )),
            SWORD_SHOP(new WorldArea(
                    new WorldPoint(2476, 5144, 0), new WorldPoint(2476, 5145, 0), new WorldPoint(2475, 5146, 0),
                    new WorldPoint(2475, 5149, 0), new WorldPoint(2478, 5150, 0), new WorldPoint(2478, 5149, 0),
                    new WorldPoint(2480, 5149, 0), new WorldPoint(2481, 5148, 0), new WorldPoint(2480, 5147, 0),
                    new WorldPoint(2481, 5146, 0), new WorldPoint(2481, 5145, 0), new WorldPoint(2480, 5144, 0)
            ));

            WorldArea area;

            Tzhaar(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Canifis {
            BOUNDS(new WorldArea(
                    new WorldPoint(3470, 3469, 0), new WorldPoint(3492, 3461, 0), new WorldPoint(3516, 3469, 0),
                    new WorldPoint(3520, 3482, 0), new WorldPoint(3518, 3487, 0), new WorldPoint(3514, 3492, 0),
                    new WorldPoint(3514, 3516, 0), new WorldPoint(3475, 3509, 0), new WorldPoint(3463, 3492, 0),
                    new WorldPoint(3463, 3466, 0)
            ));

            WorldArea area;

            Canifis(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum Rellekka {
            BOUNDS(new WorldArea(
                    new WorldPoint(2693, 3649, 0), new WorldPoint(2693, 3653, 0), new WorldPoint(2689, 3661, 0),
                    new WorldPoint(2689, 3663, 0), new WorldPoint(2691, 3667, 0), new WorldPoint(2691, 3670, 0),
                    new WorldPoint(2689, 3675, 0), new WorldPoint(2689, 3678, 0), new WorldPoint(2693, 3686, 0),
                    new WorldPoint(2693, 3690, 0), new WorldPoint(2690, 3696, 0), new WorldPoint(2690, 3698, 0),
                    new WorldPoint(2693, 3704, 0), new WorldPoint(2693, 3706, 0), new WorldPoint(2691, 3711, 0),
                    new WorldPoint(2690, 3719, 0), new WorldPoint(2692, 3729, 0), new WorldPoint(2684, 3738, 0),
                    new WorldPoint(2650, 3731, 0), new WorldPoint(2636, 3709, 0), new WorldPoint(2612, 3691, 0),
                    new WorldPoint(2597, 3655, 0), new WorldPoint(2608, 3655, 0), new WorldPoint(2611, 3653, 0),
                    new WorldPoint(2616, 3653, 0), new WorldPoint(2628, 3646, 0), new WorldPoint(2636, 3646, 0),
                    new WorldPoint(2649, 3644, 0), new WorldPoint(2652, 3645, 0), new WorldPoint(2656, 3644, 0),
                    new WorldPoint(2660, 3645, 0), new WorldPoint(2685, 3645, 0)
            )),
            LONGHALL(new WorldArea(
                    new WorldPoint(2655, 3665, 0), new WorldPoint(2662, 3685, 0)
            )),
            ROCK_CRABS(new WorldArea(
                    new WorldPoint(2653, 3711, 0), new WorldPoint(2690, 3736, 0)
            ));

            WorldArea area;

            Rellekka(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }
    }

    public enum Ham_Hideout {
        ENTRANCE(new WorldArea(new WorldPoint(3143, 9638, 0), new WorldPoint(3161, 9655, 0))),
        MIDDLE(new WorldArea(new WorldPoint(3154, 9620, 0), new WorldPoint(3177, 9640, 0)));

        WorldArea area;

        Ham_Hideout(WorldArea Area) {
            area = Area;
        }

        public WorldArea get() {
            return area;
        }

        public boolean contains(WorldPoint point) {
            return area.containsPoint(point);
        }
    }

    public static class Guilds {
        public enum Fishing {
            BOUNDS(new WorldArea(new WorldPoint(2612, 3429, 0), new WorldPoint(2615, 3413, 0), new WorldPoint(2624, 3403, 0), new WorldPoint(2624, 3399, 0),
                    new WorldPoint(2619, 3394, 0), new WorldPoint(2595, 3394, 0), new WorldPoint(2594, 3395, 0), new WorldPoint(2593, 3395, 0),
                    new WorldPoint(2592, 3396, 0), new WorldPoint(2592, 3398, 0), new WorldPoint(2589, 3401, 0), new WorldPoint(2589, 3405, 0),
                    new WorldPoint(2588, 3406, 0), new WorldPoint(2588, 3408, 0), new WorldPoint(2587, 3409, 0), new WorldPoint(2586, 3409, 0),
                    new WorldPoint(2585, 3410, 0), new WorldPoint(2585, 3413, 0), new WorldPoint(2583, 3415, 0), new WorldPoint(2580, 3415, 0),
                    new WorldPoint(2579, 3416, 0), new WorldPoint(2579, 3424, 0), new WorldPoint(2580, 3425, 0), new WorldPoint(2591, 3425, 0),
                    new WorldPoint(2592, 3424, 0), new WorldPoint(2594, 3424, 0), new WorldPoint(2596, 3426, 0)));

            WorldArea area;

            Fishing(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }
    }

    public static class Outposts {
        public enum WizardsTower {
            BOUNDS(new WorldArea(
                    new WorldPoint(3093, 3144, 0), new WorldPoint(3124, 3177, 0)
            ));

            WorldArea area;

            WizardsTower(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }

        public enum BarbOutpost {
            BOUNDS(new WorldArea(
                    new WorldPoint(2494, 3540, 0), new WorldPoint(2561, 3596, 0)
            )),
            AGILITY(new WorldArea(
                    new WorldPoint(2529, 3542, 0), new WorldPoint(2529, 3551, 0), new WorldPoint(2528, 3552, 0),
                    new WorldPoint(2528, 3557, 0), new WorldPoint(2545, 3557, 0), new WorldPoint(2546, 3558, 0),
                    new WorldPoint(2546, 3556, 0), new WorldPoint(2550, 3556, 0), new WorldPoint(2550, 3560, 0),
                    new WorldPoint(2554, 3560, 0), new WorldPoint(2554, 3542, 0)
            )),
            KEEP(new WorldArea(
                    new WorldPoint(2546, 3564, 0), new WorldPoint(2546, 3574, 0), new WorldPoint(2556, 3574, 0),
                    new WorldPoint(2556, 3560, 0), new WorldPoint(2550, 3560, 0), new WorldPoint(2550, 3564, 0)
            ));

            WorldArea area;

            BarbOutpost(WorldArea Area) {
                area = Area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }
    }

    public enum DZone {
        FULL_ZONE(new WorldArea(new WorldPoint(2818, 5056, 0), new WorldPoint(2876, 5118, 0))),
        LOBBY(new WorldArea(new WorldPoint(2831, 5090, 0), new WorldPoint(2863, 5106, 0))),
        WOODCUTTING(new WorldArea(new WorldPoint(2823, 5071, 0), new WorldPoint(2840, 5087, 0)));


        WorldArea area;
        DZone(WorldArea Area) { area = Area; }

        public WorldArea get() {return area;}
        public boolean contains(WorldPoint locatable) {
            if (area.containsPoint(locatable)) {
                return true;
            }
            return false;
        }

        public enum Dungeon {
            FULL_ZONE(new WorldArea(new WorldPoint(1900, 8960, 1), new WorldPoint(1970, 9050, 1))),
            LADDER(new WorldArea(new WorldPoint(1926, 9001, 1), new WorldPoint(1942, 9017, 1))),
            GREEN_DRAGONS(new WorldArea(new WorldPoint(1903, 8991, 1), new WorldPoint(1925, 9016, 1))),
            ROCKS(new WorldArea(new WorldPoint(1932, 9016, 1), new WorldPoint(1940, 9022, 1))),
            NECHS(new WorldArea(new WorldPoint(1926, 8985, 1), new WorldPoint(1952, 9002, 1))),
            DARK_BEASTS(new WorldArea(new WorldPoint(1918, 8962, 1), new WorldPoint(1938, 8984, 1))),
            ABBY_DEMONS(new WorldArea(new WorldPoint(1942, 8964, 1), new WorldPoint(1954, 8980, 1)));

            WorldArea area;
            Dungeon(WorldArea Area) {area = Area;}

            public WorldArea getArea() {return area;}
            public boolean contains(WorldPoint locatable) {
                if (area.containsPoint(locatable)) {
                    return true;
                }
                return false;
            }
        }
    }

    public enum Bosses {
        NIGHTMARE_LOBBY(new WorldArea(new WorldPoint(3795, 9748, 1), new WorldPoint(3820, 9771, 1))),
        NIGHTMARE(new WorldArea(new WorldPoint(3861, 9940, 3), new WorldPoint(3883, 9962, 3)));

        WorldArea area;
        Bosses(WorldArea Area) { area = Area; }

        public WorldArea get() {return area;}
        public boolean contains(WorldPoint locatable) {
            if (area.containsPoint(locatable)) {
                return true;
            }
            return false;
        }
    }

    public static class Wilderness {
        public enum Bosses {
            CALVARION(new WorldArea(new WorldPoint(1877, 11533, 1), new WorldPoint(1896, 11554, 1))),
            CALVARION_ENT(new WorldArea(new WorldPoint(3177, 3675, 0), new WorldPoint(3183, 3685, 0)));

            WorldArea area;
            Bosses(WorldArea area) {
                this.area = area;
            }

            public WorldArea get() {
                return area;
            }

            public boolean contains(WorldPoint point) {
                return area.containsPoint(point);
            }
        }
    }

}
