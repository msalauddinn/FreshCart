package com.biopic.freshcart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun rememberProducts() : SnapshotStateList<Product> {
    val productList = remember {
        mutableStateListOf(
            Product(
                id = 1,
                category = "Fruits",
                name = "Premium Fuji Apples",
                mrp = 200,
                discount = 10,
                originalPrice = 180,
                unit = "1 kg",
                stock = 45,
                image = R.drawable.apple,
                rating = 4.8f,
                smallDescription = "Crisp, sweet, and handpicked premium quality imported apples.",
                bigDescription = "Handpicked from high-altitude orchards, these premium Fuji apples are celebrated for their exceptionally crisp texture and naturally sweet, honey-like flavor profile. They are thoroughly washed, graded, and packed under strict quality controls to ensure they retain their freshness, delightful crunch, and vital nutrients during transit straight to your doorstep."
            ),

            Product(
                id = 2,
                category = "Fruits",
                name = "Robusta Bananas",
                mrp = 80,
                discount = 25,
                originalPrice = 60,
                unit = "1 Dozen",
                stock = 80,
                image = R.drawable.banana,
                rating = 4.5f,
                smallDescription = "Fresh, energy-boosting tropical bananas rich in essential potassium.",
                bigDescription = "These premium quality Robusta bananas are sustainably sourced from local tropical farms and delivered at the ideal stage of ripening. Packed with essential potassium, dietary fiber, and natural sugars, they serve as a perfect energy-boosting snack for busy mornings, a healthy addition to smoothies, or a wholesome ingredient for home baking."
            ),

            Product(
                id = 3,
                category = "Fruits",
                name = "Fresh Blueberries",
                mrp = 300,
                discount = 20,
                originalPrice = 240,
                unit = "125 g",
                stock = 15,
                image = R.drawable.blueberries,
                rating = 4.9f,
                smallDescription = "Plump, antioxidant-rich berries with a balanced sweet-tangy flavor.",
                bigDescription = "Imported from top-tier berry farms, these plump and juicy fresh blueberries offer a perfect balance of sweet and tangy flavors in every single bite. Packed with powerful antioxidants, vitamin C, and dietary fiber, they are excellent for topping your morning oatmeal, mixing into yogurt bowls, or enjoying as a guilt-free snack."
            ),

            Product(
                id = 4,
                category = "Fruits",
                name = "Valencia Oranges",
                mrp = 140,
                discount = 14,
                originalPrice = 120,
                unit = "1 kg",
                stock = 35,
                image = R.drawable.oranges,
                rating = 4.6f,
                smallDescription = "Vibrant, ultra-juicy oranges packed with immune-boosting Vitamin C.",
                bigDescription = "Sourced from sun-drenched groves, these premium Valencia oranges are famous worldwide for their high juice content and vibrant, refreshing citrus flavor. They feature a thin, easy-to-peel skin and are absolutely packed with immune-boosting Vitamin C, making them perfect for pressing fresh morning juice or tossing into vibrant summer salads."
            ),

            Product(
                id = 5,
                category = "Vegetables",
                name = "Organic Spinach Bunch",
                mrp = 40,
                discount = 25,
                originalPrice = 30,
                unit = "1 pc",
                stock = 50,
                image = R.drawable.spinach_bunch,
                rating = 4.4f,
                smallDescription = "Fresh, pesticide-free organic green leaves loaded with iron.",
                bigDescription = "Cultivated using completely organic farming methods without any synthetic pesticides, this fresh spinach bunch features tender, deep-green leaves loaded with iron, vitamins, and minerals. It is carefully harvested, thoroughly pre-washed, and bundled gently to ensure it arrives crisp and ready for healthy green smoothies, salads, or traditional sautéed dishes."
            ),

            Product(
                id = 6,
                category = "Vegetables",
                name = "Red Onions",
                mrp = 50,
                discount = 10,
                originalPrice = 45,
                unit = "1 kg",
                stock = 200,
                image = R.drawable.onions,
                rating = 4.7f,
                smallDescription = "Pungent and firm kitchen staple, ideal for daily cooking base.",
                bigDescription = "An absolute staple in kitchens worldwide, these farm-fresh red onions possess a sharp, pungent flavor when raw that beautifully mellows into a rich, sweet taste when cooked. They feature firm, multi-layered skins and are ideal for building flavor bases in curries, adding crunch to salads, or pickling for gourmet sandwiches."
            ),

            Product(
                id = 7,
                category = "Vegetables",
                name = "Hybrid Tomatoes",
                mrp = 60,
                discount = 16,
                originalPrice = 50,
                unit = "1 kg",
                stock = 120,
                image = R.drawable.tomato,
                rating = 4.3f,
                smallDescription = "Glossy, firm, and tangy tomatoes perfect for salads and curries.",
                bigDescription = "These glossy, plump hybrid tomatoes are specifically selected for their firm texture, rich red color, and well-balanced tanginess. They contain fewer seeds and a thicker pulp, making them incredibly versatile for slicing fresh into sandwiches, dicing for home-made salsas, or simmering down into thick, flavorful Italian pasta sauces and Indian curries."
            ),

            Product(
                id = 8,
                category = "Dairy & Milk",
                name = "Full Cream Milk",
                mrp = 70,
                discount = 5,
                originalPrice = 66,
                unit = "1 L",
                stock = 150,
                image = R.drawable.milk,
                rating = 4.8f,
                smallDescription = "Pasteurized high-fat milk for rich tea, coffee, and desserts.",
                bigDescription = "Formulated to provide optimal richness, this pasteurized full cream milk delivers a smooth, velvety texture and a high content of essential calcium and milk proteins. It undergoes rigorous quality checks and homogenization, making it the perfect choice for brewing rich tea or coffee, setting thick homemade yogurt, or preparing creamy desserts."
            ),

            Product(
                id = 9,
                category = "Dairy & Milk",
                name = "Fresh Paneer",
                mrp = 100,
                discount = 10,
                originalPrice = 90,
                unit = "200 g",
                stock = 40,
                image = R.drawable.paneer,
                rating = 4.6f,
                smallDescription = "Melt-in-the-mouth soft cottage cheese block made from pure milk.",
                bigDescription = "Crafted using traditional methods from pure, high-quality milk, this fresh cottage cheese block boasts an incredibly soft, melt-in-the-mouth texture. It is completely free from artificial preservatives and holds its shape beautifully when grilled, skewered for tikkas, or simmered in rich, spiced gravies like palak paneer and butter masala."
            ),

            Product(
                id = 10,
                category = "Dairy & Milk",
                name = "Salted Butter Block",
                mrp = 300,
                discount = 8,
                originalPrice = 275,
                unit = "500 g",
                stock = 65,
                image = R.drawable.butter,
                rating = 4.7f,
                smallDescription = "Creamy, savory churned butter block for spreading and baking.",
                bigDescription = "Prepared from the finest churned cream, this classic salted butter block offers a rich, savory, and deeply satisfying dairy flavor. It melts beautifully, making it an indispensable ingredient for spreading generously over hot toasts, laminating flaky breakfast pastries, or bringing a glossy, professional finish to gourmet pan sauces and gravies."
            ),

            Product(
                id = 11,
                category = "Eggs & Poultry",
                name = "Farm Fresh White Eggs",
                mrp = 100,
                discount = 10,
                originalPrice = 90,
                unit = "12 pcs",
                stock = 100,
                image = R.drawable.eggs,
                rating = 4.5f,
                smallDescription = "High-quality, protein-dense table eggs sourced from verified farms.",
                bigDescription = "Gathered daily from clean, strictly monitored poultry farms, these high-quality white table eggs are an exceptional and affordable source of lean protein and essential vitamins. Each egg features a strong shell and a rich yellow yolk, ensuring absolute freshness whether you prefer them boiled, scrambled, poached, or baked into cakes."
            ),

            Product(
                id = 12,
                category = "Eggs & Poultry",
                name = "Boneless Chicken Breast",
                mrp = 340,
                discount = 14,
                originalPrice = 290,
                unit = "1 kg",
                stock = 25,
                image = R.drawable.chicken_meat,
                rating = 4.8f,
                smallDescription = "Lean, trimmed skinless chicken breasts perfect for fitness diets.",
                bigDescription = "Cut from premium, healthy poultry, these skinless and boneless chicken breasts are completely trimmed of excess fat to offer a highly concentrated source of lean protein. Their tender texture absorbs marinades beautifully, making them ideal for healthy meal prep, fitness diets, quick stir-fries, outdoor grilling, or baking with herbs."
            ),

            Product(
                id = 13,
                category = "Eggs & Poultry",
                name = "Chicken Mince (Keema)",
                mrp = 180,
                discount = 11,
                originalPrice = 160,
                unit = "500 g",
                stock = 18,
                image = R.drawable.keema,
                rating = 4.4f,
                smallDescription = "Finely ground tender chicken meat cuts for quick-cooking recipes.",
                bigDescription = "Professionally ground from clean, tender chicken meat cuts, this fine mince provides a lightweight yet flavorful alternative to traditional red meat mince. It cooks incredibly fast and carries spices exceptionally well, making it the perfect choice for preparing juicy burger patties, homemade meatballs, traditional spiced keema mattar, or savory puff pastry fillings."
            ),

            Product(
                id = 14,
                category = "Meat & Seafood",
                name = "Fresh Salmon Fillet",
                mrp = 1050,
                discount = 9,
                originalPrice = 950,
                unit = "250 g",
                stock = 10,
                image = R.drawable.salmon_fillet,
                rating = 4.9f,
                smallDescription = "Premium Atlantic salmon fillet rich in heart-healthy Omega-3.",
                bigDescription = "Imported fresh from cold Atlantic waters, this premium salmon fillet features a beautiful pink hue and a rich, buttery texture. It is highly prized for its exceptionally high levels of heart-healthy Omega-3 fatty acids and clean taste, making it spectacular when pan-seared with lemon butter, baked with dill, or grilled over charcoal."
            ),

            Product(
                id = 15,
                category = "Meat & Seafood",
                name = "Tender Mutton Curry Cut",
                mrp = 850,
                discount = 11,
                originalPrice = 750,
                unit = "1 kg",
                stock = 15,
                image = R.drawable.mutton_curry,
                rating = 4.6f,
                smallDescription = "Juicy, bone-in goat meat pieces ideal for slow-cooked stews.",
                bigDescription = "Sourced from pasture-raised, healthy livestock, these bone-in mutton pieces are expertly cleaned and cut into uniform bite-sized portions. The meat possesses a rich, deep flavor and a tender structure that breaks down beautifully during slow-cooking, making it absolute perfection for traditional Indian mutton curries, slow-braised stews, and aromatic biryanis."
            ),

            Product(
                id = 16,
                category = "Meat & Seafood",
                name = "Freshwater Prawns",
                mrp = 440,
                discount = 13,
                originalPrice = 380,
                unit = "500 g",
                stock = 22,
                image = R.drawable.prawns,
                rating = 4.7f,
                smallDescription = "Pre-cleaned, de-veined medium prawns with a firm, snappy texture.",
                bigDescription = "Caught fresh from pristine inland water bodies, these medium-sized prawns are meticulously de-shelled, de-veined, and cleaned to save you valuable prep time in the kitchen. They feature a firm, snappy texture and a naturally sweet flavor profile that cooks in minutes, making them ideal for garlic butter stir-fries, curries, or pasta dishes."
            ),

            Product(
                id = 17,
                category = "Deli & Pre-Cooked",
                name = "Smoked Turkey Slices",
                mrp = 380,
                discount = 15,
                originalPrice = 320,
                unit = "200 g",
                stock = 14,
                image = R.drawable.turkey_slices,
                rating = 4.3f,
                smallDescription = "Hardwood-smoked, lean turkey cuts sliced thin for quick sandwiches.",
                bigDescription = "These premium turkey breast cold cuts are cured with a delicate blend of gourmet spices and naturally smoked over hardwood chips to develop a rich, savory aroma. Sliced ultra-thin for your convenience, they offer a lean, high-protein option that is instantly ready to elevate your breakfast sandwiches, club wraps, or charcuterie boards."
            ),

            Product(
                id = 18,
                category = "Deli & Pre-Cooked",
                name = "Gouda Cheese Block",
                mrp = 500,
                discount = 10,
                originalPrice = 450,
                unit = "250 g",
                stock = 20,
                image = R.drawable.cheese,
                rating = 4.6f,
                smallDescription = "Authentic semi-hard Dutch cheese with a mild, nutty profile.",
                bigDescription = "Crafted following authentic Dutch cheesemaking traditions, this semi-hard Gouda cheese block features a characteristically smooth, creamy texture and a mild, slightly nutty flavor profile. It boasts excellent melting properties, making it an exceptional choice for upgrading gourmet grilled cheese sandwiches, grating over hot pasta, or pairing elegantly with fruits and crackers."
            ),

            Product(
                id = 19,
                category = "Deli & Pre-Cooked",
                name = "Stuffed Green Olives",
                mrp = 250,
                discount = 16,
                originalPrice = 210,
                unit = "300 g",
                stock = 30,
                image = R.drawable.green_olives,
                rating = 4.2f,
                smallDescription = "Pitted Mediterranean green olives stuffed with tangy pimento paste.",
                bigDescription = "Handpicked from premium Mediterranean groves, these plump, savory green olives are carefully pitted and stuffed with a vibrant, tangy red pimento paste. Preserved in a light, perfectly balanced brine, they deliver a sophisticated burst of salty and savory flavors, making them an excellent appetizer, cocktail garnish, or pizza topping."
            ),

            Product(
                id = 20,
                category = "Grains & Rice",
                name = "Premium Basmati Rice",
                mrp = 170,
                discount = 14,
                originalPrice = 145,
                unit = "1 kg",
                stock = 85,
                image = R.drawable.basmati,
                rating = 4.9f,
                smallDescription = "Perfectly aged, aromatic long-grain rice for biryanis and pulaos.",
                bigDescription = "Aged to perfection for over a year, this premium long-grain Basmati rice expands to more than twice its original length when cooked. It releases a captivating, natural floral aroma and cooks into perfectly distinct, non-sticky, fluffy grains, making it the ultimate selection for royal biryanis, festive pulaos, or complementing rich dal makhani."
            ),

            Product(
                id = 21,
                category = "Grains & Rice",
                name = "Organic Quinoa Seeds",
                mrp = 350,
                discount = 14,
                originalPrice = 299,
                unit = "500 g",
                stock = 40,
                image = R.drawable.quinoa,
                rating = 4.5f,
                smallDescription = "Gluten-free, pre-washed superfood grain rich in complete protein.",
                bigDescription = "Sourced from certified organic farms, this premium whole-grain quinoa is a complete plant-based protein containing all nine essential amino acids. It has been thoroughly pre-washed to remove bitter saponins, leaving a clean, nutty flavor and a delightfully fluffy texture that serves as an excellent gluten-free substitute for rice or couscous."
            ),

            Product(
                id = 22,
                category = "Grains & Rice",
                name = "Rolled Oats",
                mrp = 220,
                discount = 13,
                originalPrice = 190,
                unit = "1 kg",
                stock = 70,
                image = R.drawable.oats,
                rating = 4.6f,
                smallDescription = "100% whole grain fiber-rich rolled oats for healthy breakfasts.",
                bigDescription = "Made from 100% whole grain oats that are gently steamed and rolled flat, these oats retain all their natural bran and germ layers. They are rich in soluble beta-glucan fiber, which helps manage cholesterol levels, and offer a hearty, comforting texture that keeps you feeling satisfied for hours when prepared as porridge or baked goods."
            ),

            Product(
                id = 23,
                category = "Flours & Baking",
                name = "Chakki Fresh Atta",
                mrp = 300,
                discount = 13,
                originalPrice = 260,
                unit = "5 kg",
                stock = 110,
                image = R.drawable.atta,
                rating = 4.8f,
                smallDescription = "Stone-ground whole wheat flour for making soft, fluffy rotis.",
                bigDescription = "Ground traditionally in heavy stone mills (chakkis) from selected high-quality wheat grains, this 100% whole wheat flour retains all its natural dietary fiber and nutrients. It absorbs water efficiently to create a smooth, pliable dough, ensuring your daily rotis, phulkas, and paranthas turn out incredibly soft, fluffy, and wholesome every single time."
            ),

            Product(
                id = 24,
                category = "Flours & Baking",
                name = "Refined Flour (Maida)",
                mrp = 50,
                discount = 10,
                originalPrice = 45,
                unit = "1 kg",
                stock = 90,
                image = R.drawable.maida,
                rating = 4.4f,
                smallDescription = "Finely milled, high-elasticity flour perfect for baking and pastries.",
                bigDescription = "Super-finely milled and carefully sifted, this premium refined wheat flour offers a remarkably smooth texture and excellent gluten elasticity. It is the gold standard ingredient for baking airy sponge cakes, flaky pastries, crispy biscuits, as well as preparing traditional street foods like bhaturas, naans, and homemade wrappers for steamed momos."
            ),

            Product(
                id = 25,
                category = "Flours & Baking",
                name = "Fine White Sugar",
                mrp = 55,
                discount = 9,
                originalPrice = 50,
                unit = "1 kg",
                stock = 130,
                image = R.drawable.sugar,
                rating = 4.5f,
                smallDescription = "Sulfur-free, rapid-dissolving pure granulated sugar crystals.",
                bigDescription = "Processed without the use of harmful sulfur agents, these pure white granulated sugar crystals dissolve rapidly and cleanly into liquids. They provide a perfectly clean, sweet taste without any unpleasant aftertaste, making them absolutely essential for sweetening daily tea, baking delicate confections, or balancing savory tomato sauces and marinades."
            ),

            Product(
                id = 26,
                category = "Flours & Baking",
                name = "Active Dry Yeast",
                mrp = 100,
                discount = 15,
                originalPrice = 85,
                unit = "50 g",
                stock = 45,
                image = R.drawable.yeast,
                rating = 4.7f,
                smallDescription = "High-potency leavening agent for uniform artisanal bread rises.",
                bigDescription = "This highly reliable, professional-grade active dry yeast guarantees a powerful and uniform leavening action for all your home-baking projects. It activates easily in warm water, producing a robust carbon dioxide release that creates beautifully airy crumb structures in artisanal sourdoughs, soft sandwich breads, sweet brioches, and classic thin-crust Italian pizza doughs."
            ),

            Product(
                id = 27,
                category = "Pulses & Lentils",
                name = "Unpolished Toor Dal",
                mrp = 200,
                discount = 12,
                originalPrice = 175,
                unit = "1 kg",
                stock = 95,
                image = R.drawable.toor_dal,
                rating = 4.7f,
                smallDescription = "Natural, unpolished split pigeon peas rich in plant protein.",
                bigDescription = "Completely free from artificial water, oil, or leather polishing agents, this premium split pigeon pea (toor dal) retains its natural outer nutrient layer and authentic taste. It is an excellent source of plant protein and dietary fiber, cooking down into a beautifully thick, comforting texture perfect for classic yellow dal tadka."
            ),

            Product(
                id = 28,
                category = "Pulses & Lentils",
                name = "Organic Chickpeas",
                mrp = 160,
                discount = 12,
                originalPrice = 140,
                unit = "1 kg",
                stock = 80,
                image = R.drawable.chickpeas,
                rating = 4.6f,
                smallDescription = "Large-sized white organic chickpeas with a creamy texture.",
                bigDescription = "Sourced from certified organic farms, these premium white chickpeas are uniform in size, free from debris, and boast a creamy, nutty texture when cooked. They absorb aromatic spices beautifully, making them the absolute perfect choice for preparing traditional North Indian Chole Bhature, Mediterranean hummus dips, or healthy, protein-packed cold summer salads."
            ),

            Product(
                id = 29,
                category = "Pulses & Lentils",
                name = "Split Moong Dal",
                mrp = 170,
                discount = 11,
                originalPrice = 150,
                unit = "1 kg",
                stock = 75,
                image = R.drawable.moong_dal,
                rating = 4.5f,
                smallDescription = "Quick-cooking, easy-to-digest yellow split lentils for light meals.",
                bigDescription = "These premium yellow split mung beans are light on the stomach, incredibly easy to digest, and cook exceptionally fast without needing hours of pre-soaking. Packed with essential vitamins and clean protein, they are the traditional go-to ingredient for preparing wholesome khichdi, healing broths, or crispy, savory pan-fried moong dal cheelas."
            ),

            Product(
                id = 30,
                category = "Pasta & Noodles",
                name = "Durum Wheat Spaghetti",
                mrp = 150,
                discount = 16,
                originalPrice = 125,
                unit = "500 g",
                stock = 60,
                image = R.drawable.wheat_spaghetti,
                rating = 4.6f,
                smallDescription = "100% durum wheat semolina long-cut Italian style pasta.",
                bigDescription = "Crafted from 100% premium durum wheat semolina, this traditional long-cut Italian spaghetti cooks to a perfect 'al dente' firmness every time. Its slightly textured surface is expertly engineered to grip onto sauces efficiently, whether you are tossing it in a simple garlic olive oil mix or a rich, slow-simmered bolognese sauce."
            ),

            Product(
                id = 31,
                category = "Pasta & Noodles",
                name = "Instant Masala Noodles",
                mrp = 20,
                discount = 10,
                originalPrice = 18,
                unit = "70 g",
                stock = 500,
                image = R.drawable.maggi,
                rating = 4.8f,
                smallDescription = "Quick 3-minute comfort noodles with a classic savory spice blend.",
                bigDescription = "The ultimate midnight comfort snack, this instant noodle pack features pre-fried, quick-cooking wheat noodles paired with a highly aromatic spice tastemaker sachet. Ready in just under three minutes, it delivers a satisfying burst of savory, spicy Indian flavors that have made it a favorite across generations of students and busy professionals."
            ),

            Product(
                id = 32,
                category = "Pasta & Noodles",
                name = "Spicy Korean Ramen",
                mrp = 130,
                discount = 11,
                originalPrice = 115,
                unit = "140 g",
                stock = 140,
                image = R.drawable.ramen,
                rating = 4.7f,
                smallDescription = "Fiery, chewy wheat noodles in intense chili broth flavor.",
                bigDescription = "Experience the fiery, authentic flavors of Seoul with this ultra-spicy instant Korean ramen pack. It features thick, satisfyingly chewy wheat noodles paired with an intense, deeply savory broth infused with red chili paste, garlic, and scallions, providing an exhilarating culinary challenge for spice lovers looking for a quick, hearty meal."
            ),

            Product(
                id = 33,
                category = "Canned Goods",
                name = "Diced Tomatoes",
                mrp = 110,
                discount = 13,
                originalPrice = 95,
                unit = "400 g",
                stock = 40,
                image = R.drawable.diced_tomato,
                rating = 4.4f,
                smallDescription = "Pantry-stable vine-ripened diced tomatoes preserved in rich juice.",
                bigDescription = "Vine-ripened under the Mediterranean sun, these plump tomatoes are peeled, diced uniformally, and immediately preserved in their own thick, rich tomato juice. Free from artificial citric acids or heavy preservatives, they offer a convenient, pantry-stable way to add instant depth, color, and tanginess to your homemade soups, stews, and pasta sauces."
            ),

            Product(
                id = 34,
                category = "Canned Goods",
                name = "Sweet Corn Kernels",
                mrp = 100,
                discount = 15,
                originalPrice = 85,
                unit = "400 g",
                stock = 65,
                image = R.drawable.sweet_corn,
                rating = 4.5f,
                smallDescription = "Crisp, golden sweet corn kernels vacuum-packed in light brine.",
                bigDescription = "Plucked at the absolute peak of sweetness, these golden sweet corn kernels are vacuum-packed in a light, naturally salted brine to preserve their signature crisp bite. They are instantly ready to eat cold or hot, making them a colorful and crunchy addition to fresh garden salads, cheesy pizzas, or creamy corn chowders."
            ),

            Product(
                id = 35,
                category = "Canned Goods",
                name = "Cream of Mushroom Soup",
                mrp = 130,
                discount = 15,
                originalPrice = 110,
                unit = "300 ml",
                stock = 35,
                image = R.drawable.mashroom_soup,
                rating = 4.1f,
                smallDescription = "Thick condensed soup blend featuring real button mushrooms and cream.",
                bigDescription = "This rich, condensed cream of mushroom soup is crafted with a luxurious blend of real, earthy button mushrooms, fresh dairy cream, and a delicate touch of garlic and ground black pepper. It serves as a comforting standalone hot soup or as an excellent, time-saving flavor base for comforting baked casseroles."
            ),

            Product(
                id = 36,
                category = "Oils, Ghee & Fats",
                name = "Cold Pressed Mustard Oil",
                mrp = 220,
                discount = 11,
                originalPrice = 195,
                unit = "1 L",
                stock = 85,
                image = R.drawable.mustard_oil,
                rating = 4.8f,
                smallDescription = "Pungent, wood-pressed pure mustard oil with a high smoke point.",
                bigDescription = "Extracted using traditional wood-pressing methods at low temperatures, this unrefined mustard oil retains its intense, pungent aroma, rich golden hue, and natural antioxidants. It has a remarkably high smoke point, making it the perfect choice for traditional Indian deep-frying, tempering spices, and authentic North Indian pickling recipes."
            ),

            Product(
                id = 37,
                category = "Oils, Ghee & Fats",
                name = "Pure Cow Ghee Tin",
                mrp = 750,
                discount = 8,
                originalPrice = 690,
                unit = "1 L",
                stock = 50,
                image = R.drawable.cow_ghee,
                rating = 4.9f,
                smallDescription = "Aromatic, granular clarified butter made from pure milk fat.",
                bigDescription = "Prepared using the traditional granular method from pure milk fat, this aromatic clarified butter (ghee) features a gorgeous golden color and a rich, nutty fragrance. Free from trans-fats and additives, it enhances the flavor of hot rotis, acts as a rich cooking medium for biryanis, and holds a sacred place in Indian culinary heritage."
            ),

            Product(
                id = 38,
                category = "Oils, Ghee & Fats",
                name = "Extra Virgin Olive Oil",
                mrp = 1000,
                discount = 15,
                originalPrice = 850,
                unit = "1 L",
                stock = 30,
                image = R.drawable.olive_oil,
                rating = 4.7f,
                smallDescription = "First cold-press oil for elegant salad dressings and dips.",
                bigDescription = "Obtained exclusively from the very first cold-pressing of premium handpicked olives, this extra virgin olive oil features a beautiful greenish-gold hue and a delicate, fruity flavor with a signature peppery finish. It is best enjoyed raw as a dressing for fresh salads, a gourmet dip for artisanal breads, or for drizzling over cooked pastas."
            ),

            Product(
                id = 39,
                category = "Condiments",
                name = "Tomato Ketchup Squeezy",
                mrp = 160,
                discount = 12,
                originalPrice = 140,
                unit = "950 g",
                stock = 75,
                image = R.drawable.tomato_ketchup,
                rating = 4.6f,
                smallDescription = "Classic sweet and tangy ketchup in a mess-free squeezy bottle.",
                bigDescription = "Made from a secret blend of sweet, vine-ripened tomatoes and choice ground spices, this classic tomato ketchup offers a perfectly balanced sweet and tangy flavor. Packaged in a convenient, mess-free squeezy bottle, it is the ultimate dipping companion for hot French fries, crispy chicken nuggets, grilled sandwiches, and burgers."
            ),

            Product(
                id = 40,
                category = "Condiments",
                name = "Eggless Mayonnaise",
                mrp = 140,
                discount = 14,
                originalPrice = 120,
                unit = "400 g",
                stock = 60,
                image = R.drawable.mayonnaise,
                rating = 4.5f,
                smallDescription = "100% vegetarian, thick and smooth mayonnaise base for spreads.",
                bigDescription = "This 100% vegetarian, eggless mayonnaise delivers an incredibly thick, smooth, and velvety texture without compromising on the classic, rich flavor profile. It spreads effortlessly, making it an excellent base for home-made sandwich spreads, creamy coleslaw salads, dipping sauces for finger foods, or wrapping into delicious vegetable rolls."
            ),

            Product(
                id = 41,
                category = "Condiments",
                name = "Dark Soy Sauce",
                mrp = 100,
                discount = 10,
                originalPrice = 90,
                unit = "200 ml",
                stock = 45,
                image = R.drawable.soya_sauce,
                rating = 4.4f,
                smallDescription = "Naturally brewed deep umami soy sauce for Indo-Chinese recipes.",
                bigDescription = "Naturally brewed over several months from premium soybeans and wheat, this rich dark soy sauce adds a deep, savory umami depth and a beautiful caramel color to dishes. It is an indispensable ingredient for authentic Indo-Chinese cooking, perfect for stir-frying Hakka noodles, glazing proteins, or creating dipping sauces."
            ),

            Product(
                id = 42,
                category = "Spices & Herbs",
                name = "Table Salt (Iodized)",
                mrp = 30,
                discount = 6,
                originalPrice = 28,
                unit = "1 kg",
                stock = 300,
                image = R.drawable.salt,
                rating = 4.7f,
                smallDescription = "Free-flowing, vacuum-evaporated table salt fortified with essential iodine.",
                bigDescription = "A fundamental element of every recipe, this premium vacuum-evaporated table salt is fortified with essential dietary iodine to support thyroid health. It features perfectly uniform, free-flowing crystal granules that dissolve instantly, ensuring a highly accurate and balanced seasoning experience across all your daily cooking and baking ventures."
            ),

            Product(
                id = 43,
                category = "Spices & Herbs",
                name = "Organic Turmeric Powder",
                mrp = 75,
                discount = 13,
                originalPrice = 65,
                unit = "200 g",
                stock = 110,
                image = R.drawable.turmeric_powder,
                rating = 4.8f,
                smallDescription = "Vibrant golden spice with high curcumin for warmth and wellness.",
                bigDescription = "Sourced from pristine organic farms, this vibrant golden-yellow turmeric powder boasts exceptionally high levels of natural curcumin, known for its powerful anti-inflammatory properties. It adds a deep earthy warmth, beautiful natural color, and a subtle woody aroma to traditional curries, lentil soups, and trendy wellness golden milk recipes."
            ),

            Product(
                id = 44,
                category = "Spices & Herbs",
                name = "Premium Garam Masala",
                mrp = 100,
                discount = 10,
                originalPrice = 90,
                unit = "100 g",
                stock = 85,
                image = R.drawable.garam_masala,
                rating = 4.6f,
                smallDescription = "Dry-roasted complex whole spice blend to finish aromatic curries.",
                bigDescription = "A masterfully balanced blend of premium whole spices, including black cardamom, cinnamon, cloves, and mace, which are gently dry-roasted and ground to perfection. This highly aromatic spice blend is designed to be sprinkled over curries and stir-fries during the final stages of cooking, imparting a warm, sophisticated, and deeply complex flavor."
            ),

            Product(
                id = 45,
                category = "Breakfast",
                name = "Crunchy Corn Flakes",
                mrp = 250,
                discount = 12,
                originalPrice = 220,
                unit = "500 g",
                stock = 55,
                image = R.drawable.cornflake,
                rating = 4.3f,
                smallDescription = "Low-fat, iron-rich toasted corn flakes for crisp morning energy.",
                bigDescription = "Made from sun-ripened, milled corn grains that are gently toasted to golden perfection, these crispy corn flakes provide a classic, low-fat breakfast option. High in iron and essential B-vitamins, they pair beautifully with cold or warm milk and fresh sliced fruits to give you a quick, energizing start to your morning."
            ),

            Product(
                id = 46,
                category = "Breakfast",
                name = "Creamy Peanut Butter",
                mrp = 190,
                discount = 13,
                originalPrice = 165,
                unit = "350 g",
                stock = 40,
                image = R.drawable.peanut_butter,
                rating = 4.7f,
                smallDescription = "Unsweetened pure roasted peanut spread containing zero trans-fats.",
                bigDescription = "Crafted solely from slow-roasted, premium quality peanuts and a pinch of salt, this ultra-creamy peanut butter delivers a powerful dose of plant-based protein and healthy fats. Completely free from hydrogenated oils and added sugars, it spreads beautifully over toast, blends into protein shakes, or serves as a rich baking ingredient."
            ),

            Product(
                id = 47,
                category = "Breakfast",
                name = "Mixed Fruit Jam Puree",
                mrp = 150,
                discount = 13,
                originalPrice = 130,
                unit = "500 g",
                stock = 65,
                image = R.drawable.fruit_jam,
                rating = 4.5f,
                smallDescription = "Sweet breakfast jam spread made from real mixed fruit pulps.",
                bigDescription = "A delicious, sweet medley featuring the real pulps of handpicked apples, pineapples, papayas, mangoes, and grapes blended seamlessly together. This vibrant fruit jam delivers a burst of summertime flavors in every spoonful, making it an absolute favorite spread for children and adults alike when paired with soft bread or warm paranthas."
            ),

            Product(
                id = 48,
                category = "Snacks",
                name = "Classic Potato Chips",
                mrp = 35,
                discount = 14,
                originalPrice = 30,
                unit = "100 g",
                stock = 250,
                image = R.drawable.potato_chips,
                rating = 4.6f,
                smallDescription = "Ultra-thin golden potato chips perfectly dusted with fine sea salt.",
                bigDescription = "Made from specially selected, high-starch potatoes sliced to an ultra-thin specification, these chips are fried to a perfect golden crispness in clean vegetable oil. Lightly dusted with fine sea salt, they offer a timeless, exceptionally crunchy snacking experience that is perfect for party bowls, movie nights, or mid-day cravings."
            ),

            Product(
                id = 49,
                category = "Snacks",
                name = "Chocolate Chip Cookies",
                mrp = 45,
                discount = 11,
                originalPrice = 40,
                unit = "120 g",
                stock = 180,
                image = R.drawable.chip_cookies,
                rating = 4.4f,
                smallDescription = "Crunchy baked cookies loaded with melting dark chocolate chips.",
                bigDescription = "Baked to a perfect golden brown, these premium cookies offer a delightful crunch on the outside while remaining tender within. They are generously loaded with rich, melt-in-the-mouth dark chocolate chips, creating an indulgent sweet treat that pairs impeccably with a hot glass of milk, afternoon tea, or a casual coffee break."
            ),

            Product(
                id = 50,
                category = "Snacks",
                name = "Roasted Salted Cashews",
                mrp = 400,
                discount = 15,
                originalPrice = 340,
                unit = "200 g",
                stock = 50,
                image = R.drawable.salted_cashews,
                rating = 4.8f,
                smallDescription = "Dry-roasted premium jumbo cashews with a rich buttery crunch.",
                bigDescription = "These premium, whole jumbo cashew nuts are uniformly dry-roasted to bring out their natural, rich buttery sweetness before being lightly tossed in fine sea salt. Packed with healthy fats, proteins, and minerals, they provide a highly satisfying, premium snack option or a sophisticated addition to festive nut platters."
            ),

            Product(
                id = 51,
                category = "Beverages",
                name = "Premium Assam Black Tea",
                mrp = 360,
                discount = 11,
                originalPrice = 320,
                unit = "1 kg",
                stock = 90,
                image = R.drawable.assam_tea,
                rating = 4.8f,
                smallDescription = "Strong, malty full-bodied CTC tea leaves perfect for milk tea.",
                bigDescription = "Sourced directly from the lush, fertile tea estates of the Assam valley, these high-grade CTC tea leaves brew into a deeply colored, exceptionally strong, and full-bodied cup. Characterized by its rich, malty flavor notes, it is the ideal choice for preparing traditional milk-based Indian masala chai to jumpstart your mornings."
            ),

            Product(
                id = 52,
                category = "Beverages",
                name = "Classic Instant Coffee",
                mrp = 200,
                discount = 7,
                originalPrice = 185,
                unit = "100 g",
                stock = 75,
                image = R.drawable.coffee,
                rating = 4.7f,
                smallDescription = "Richly aromatic 100% pure dark-roasted coffee crystals.",
                bigDescription = "Expertly crafted from a premium blend of dark-roasted Arabica and Robusta coffee beans, this instant coffee powder dissolves effortlessly in hot milk or water. It releases an intensely rich, comforting aroma and delivers a bold, smooth coffee flavor with a velvety crema finish, offering an instant, premium cafe experience right at home."
            ),

            Product(
                id = 53,
                category = "Beverages",
                name = "Pure Green Tea Bags",
                mrp = 250,
                discount = 16,
                originalPrice = 210,
                unit = "25 pcs",
                stock = 60,
                image = R.drawable.green_tea,
                rating = 4.5f,
                smallDescription = "Zero-calorie, antioxidant-dense green tea leaves in filter bags.",
                bigDescription = "Sourced from high-altitude tea gardens, these zero-calorie green tea bags contain gently steamed whole leaves that preserve their natural green color and high antioxidant profile. When steeped, the tea offers a light, soothing liquor with a subtle grassy note and a clean finish, making it perfect for your daily detoxification rituals."
            ),

            Product(
                id = 54,
                category = "Juices & Sodas",
                name = "100% Pure Orange Juice",
                mrp = 150,
                discount = 16,
                originalPrice = 125,
                unit = "1 L",
                stock = 80,
                image = R.drawable.orange_juice,
                rating = 4.6f,
                smallDescription = "No added sugar or preservatives, fresh-pressed premium orange juice.",
                bigDescription = "Flash-pasteurized to preserve maximum freshness, this premium packaged juice contains 100% pure liquid squeezed from sweet, sun-ripened oranges. Absolutely free from added sugars, water, or chemical preservatives, it delivers a clean, vibrantly refreshing taste that provides a healthy dose of natural hydration and Vitamin C for the entire family."
            ),

            Product(
                id = 55,
                category = "Juices & Sodas",
                name = "Cola Carbonated Drink",
                mrp = 45,
                discount = 11,
                originalPrice = 40,
                unit = "750 ml",
                stock = 200,
                image = R.drawable.coca_cola,
                rating = 4.5f,
                smallDescription = "Sparkling, refreshing carbonated soft drink best served ice-cold.",
                bigDescription = "A timeless and globally loved carbonated soft drink, this sparkling beverage delivers an intensely refreshing burst of sweet cola flavor and lively carbonation bubbles. Best served ice-cold, it serves as the ultimate refreshing companion for spicy meals, outdoor summer barbecues, casual social gatherings, or relaxing movie nights at home."
            ),

            Product(
                id = 56,
                category = "Juices & Sodas",
                name = "Natural Sparkling Water",
                mrp = 70,
                discount = 14,
                originalPrice = 60,
                unit = "500 ml",
                stock = 95,
                image = R.drawable.water,
                rating = 4.2f,
                smallDescription = "Effervescent spring water with zero calories or sweeteners.",
                bigDescription = "Sourced from pristine underground springs, this natural sparkling water is infused with gentle carbonation bubbles to offer a clean, crisp, and incredibly effervescent palate cleanser. Featuring zero calories, zero sugars, and no artificial sweeteners, it is a sophisticated and healthy alternative to traditional sugary sodas and soft drinks."
            ),

            Product(
                id = 57,
                category = "Frozen Foods",
                name = "Frozen Tender Green Peas",
                mrp = 110,
                discount = 13,
                originalPrice = 95,
                unit = "500 g",
                stock = 70,
                image = R.drawable.green_peas,
                rating = 4.6f,
                smallDescription = "IQF flash-frozen sweet green peas with no prep work required.",
                bigDescription = "Harvested at the absolute peak of sweetness, these tender green peas are individually quick-frozen (IQF) within hours of picking to lock in their bright green color, crisp texture, and natural nutritional value. They require zero shelling or prep work, making them a highly convenient addition to curries, pulaos, or stir-fries."
            ),

            Product(
                id = 58,
                category = "Frozen Foods",
                name = "French Fries",
                mrp = 160,
                discount = 12,
                originalPrice = 140,
                unit = "750 g",
                stock = 55,
                image = R.drawable.french_fries,
                rating = 4.4f,
                smallDescription = "Flash-frozen restaurant style crispy potato fries for deep frying.",
                bigDescription = "Cut from premium quality, select processing potatoes, these French fries are lightly blanched and par-fried before being flash-frozen. They transfer straight from your freezer to hot oil or an air fryer, cooking up into a flawless restaurant-style finish that features an incredibly crispy golden exterior and a fluffy, potato-rich interior."
            ),

            Product(
                id = 59,
                category = "Frozen Foods",
                name = "Belgian Chocolate Ice Cream",
                mrp = 320,
                discount = 15,
                originalPrice = 270,
                unit = "700 ml",
                stock = 40,
                image = R.drawable.ice_cream,
                rating = 4.9f,
                smallDescription = "Gourmet rich chocolate ice cream loaded with fine dark flakes.",
                bigDescription = "Crafted using premium imported Belgian cocoa powder and fresh, rich dairy cream, this gourmet ice cream provides an incredibly dense, velvety, and deeply chocolatey dessert experience. Dotted with fine dark chocolate flecks throughout, it is the ultimate premium indulgence for chocolate connoisseurs looking for a rich after-dinner sweet treat."
            ),

            Product(
                id = 60,
                category = "Cleaning & Care",
                name = "Liquid Dishwashing Gel",
                mrp = 180,
                discount = 13,
                originalPrice = 155,
                unit = "750 ml",
                stock = 65,
                image = R.drawable.liquid_dishwasher,
                rating = 4.6f,
                smallDescription = "Concentrated lemon-extract formula that easily cuts tough grease.",
                bigDescription = "Formulated with an advanced, concentrated grease-cutting formula, this high-efficiency dishwashing liquid removes stubborn, burnt-on food residues and heavy oil stains with absolute ease. Infused with natural lemon extracts, it sanitizes your cookware perfectly, leaving your expensive ceramic plates and stainless steel pans sparkling clean and smelling beautifully fresh."
            ),

            Product(
                id = 61,
                category = "Cleaning & Care",
                name = "Matik Laundry Detergent",
                mrp = 500,
                discount = 14,
                originalPrice = 430,
                unit = "2 kg",
                stock = 45,
                image = R.drawable.detergent,
                rating = 4.5f,
                smallDescription = "High-efficiency machine washing powder featuring oxygen bleach tech.",
                bigDescription = "Specially engineered for both top and front-load washing machines, this high-performance laundry detergent powder dissolves completely even in cold water without leaving any residue behind. It features built-in oxygen bleach technology that lifts deep fabric stains effortlessly while protecting the vibrancy of your colored clothes and structural integrity of whites."
            ),

            Product(
                id = 62,
                category = "Cleaning & Care",
                name = "Total Care Toothpaste",
                mrp = 110,
                discount = 13,
                originalPrice = 95,
                unit = "150 g",
                stock = 120,
                image = R.drawable.toothpaste,
                rating = 4.6f,
                smallDescription = "Multi-benefit active fluoride toothpaste with fresh mint crystals.",
                bigDescription = "Developed alongside dental experts, this advanced multi-benefit toothpaste features active fluoride and cooling mint crystals to deliver comprehensive oral protection. It actively fights cavity-causing bacteria, removes surface enamel stains for a brighter smile, strengthens gum tissue, and provides long-lasting, icy fresh breath confidence that endures throughout your busy day."
            ),

            Product(
                id = 63,
                category = "Cleaning & Care",
                name = "3-Ply Toilet Paper Rolls",
                mrp = 200,
                discount = 10,
                originalPrice = 180,
                unit = "4 pcs",
                stock = 50,
                image = R.drawable.toilet_paper,
                rating = 4.7f,
                smallDescription = "Ultra-soft, biodegradable virgin wood pulp 3-ply tissue rolls.",
                bigDescription = "Manufactured from 100% natural, sustainably sourced virgin wood pulp, these premium toilet paper rolls feature an advanced 3-ply thickness for ultimate strength and absorbency. They are intricately embossed to provide a remarkably soft, gentle texture against sensitive skin while remaining completely biodegradable, septic-safe, and free from harsh chemical bleaching agents."
            )
        )
    }

    return productList
}
