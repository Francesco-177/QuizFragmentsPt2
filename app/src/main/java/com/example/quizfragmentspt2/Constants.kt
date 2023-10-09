package com.example.quizfragmentspt2


object Constants{



    fun getQuestions(): ArrayList<Question> {

        val questionList = ArrayList<Question>()

        // Legendary Drivers Category id:1-20
        questionList.add(
            Question(
                id = 1,
                question = "Who is the only driver to win the Formula 1 World Championship with both Ferrari and McLaren?",
                optionOne = "Ayrton Senna",
                optionTwo = "Michael Schumacher",
                optionThree = "Fernando Alonso",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 2,
                question = "Which Formula 1 legend is known for his famous quote 'If you no longer go for a gap that exists, you are no longer a racing driver'?",
                optionOne = "Juan Manuel Fangio",
                optionTwo = "Niki Lauda",
                optionThree = "Ayrton Senna",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 3,
                question = "How many Formula 1 World Championships did Juan Manuel Fangio win during his career?",
                optionOne = "3",
                optionTwo = "5",
                optionThree = "7",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 4,
                question = "Who is often referred to as the 'Flying Scot' in Formula 1?",
                optionOne = "Jim Clark",
                optionTwo = "Jackie Stewart",
                optionThree = "Graham Hill",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 5,
                question = "Which legendary Brazilian driver won the Formula 1 World Championship three times?",
                optionOne = "Ayrton Senna",
                optionTwo = "Emerson Fittipaldi",
                optionThree = "Nelson Piquet",
                correctAnswer = 2,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 6,
                question = "Who is the only driver to have won the Formula 1 World Championship posthumously?",
                optionOne = "Jim Clark",
                optionTwo = "Jochen Rindt",
                optionThree = "Gilles Villeneuve",
                correctAnswer = 2,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 7,
                question = "Which Formula 1 driver is known for his record of seven World Championships?",
                optionOne = "Michael Schumacher",
                optionTwo = "Lewis Hamilton",
                optionThree = "Juan Manuel Fangio",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 8,
                question = "Who is considered one of the greatest Formula 1 drivers of all time and is known as the 'Maestro'?",
                optionOne = "Niki Lauda",
                optionTwo = "Alain Prost",
                optionThree = "Juan Manuel Fangio",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 9,
                question = "Which British driver won his first Formula 1 World Championship with McLaren in 2008?",
                optionOne = "Jenson Button",
                optionTwo = "David Coulthard",
                optionThree = "Lewis Hamilton",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 10,
                question = "Who is the only driver to win the Formula 1 World Championship with four different teams?",
                optionOne = "Michael Schumacher",
                optionTwo = "Sebastian Vettel",
                optionThree = "Juan Manuel Fangio",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 11,
                question = "Which Finnish driver is known for his nickname 'The Flying Finn'?",
                optionOne = "Kimi Räikkönen",
                optionTwo = "Mika Häkkinen",
                optionThree = "Valtteri Bottas",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 12,
                question = "Who is the most successful British driver in Formula 1 history with seven World Championships?",
                optionOne = "David Coulthard",
                optionTwo = "Lewis Hamilton",
                optionThree = "Nigel Mansell",
                correctAnswer = 2,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 13,
                question = "Which Italian driver is known for his nickname 'SuperSwede'?",
                optionOne = "Giancarlo Fisichella",
                optionTwo = "Riccardo Patrese",
                optionThree = "Ronnie Peterson",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 14,
                question = "Who is the first driver to win the Formula 1 World Championship with a turbocharged car?",
                optionOne = "Nelson Piquet",
                optionTwo = "Alain Prost",
                optionThree = "Niki Lauda",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 15,
                question = "Which Brazilian driver won three Formula 1 World Championships during his career?",
                optionOne = "Ayrton Senna",
                optionTwo = "Nelson Piquet",
                optionThree = "Emerson Fittipaldi",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 16,
                question = "Who was the first American driver to win a Formula 1 race?",
                optionOne = "Mario Andretti",
                optionTwo = "Dan Gurney",
                optionThree = "Michael Andretti",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 17,
                question = "Which Austrian driver is known for his nickname 'The Red Bull Ringmaster'?",
                optionOne = "Gerhard Berger",
                optionTwo = "Niki Lauda",
                optionThree = "Alexander Wurz",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 18,
                question = "Who is the only Dutch driver to win the Formula 1 World Championship?",
                optionOne = "Max Verstappen",
                optionTwo = "Jan Lammers",
                optionThree = "Jos Verstappen",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 19,
                question = "Which British driver is known for his nickname 'The Professor'?",
                optionOne = "Nigel Mansell",
                optionTwo = "David Coulthard",
                optionThree = "Alain Prost",
                correctAnswer = 3,
                category = "Legendary Drivers"
            )
        )

        questionList.add(
            Question(
                id = 20,
                question = "Who is the only driver to have won the Formula 1 World Championship with a privately-owned team?",
                optionOne = "Graham Hill",
                optionTwo = "Stirling Moss",
                optionThree = "Jack Brabham",
                correctAnswer = 1,
                category = "Legendary Drivers"
            )
        )

        // Historic Teams Category id:21-40
        questionList.add(
            Question(
                id = 21,
                question = "Which Formula 1 team holds the record for the most Constructors' Championships?",
                optionOne = "Ferrari",
                optionTwo = "McLaren",
                optionThree = "Mercedes",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 22,
                question = "How many Constructors' Championships did the Williams F1 Team win during the 1990s?",
                optionOne = "2",
                optionTwo = "5",
                optionThree = "7",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 23,
                question = "Which team won the inaugural Formula 1 Constructors' Championship in 1958?",
                optionOne = "Ferrari",
                optionTwo = "Mercedes",
                optionThree = "Cooper",
                correctAnswer = 3,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 24,
                question = "In which decade did Scuderia Ferrari make their Formula 1 debut?",
                optionOne = "1940s",
                optionTwo = "1950s",
                optionThree = "1960s",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 25,
                question = "Which Formula 1 team is known for its distinctive red cars?",
                optionOne = "Red Bull Racing",
                optionTwo = "Alpine F1 Team",
                optionThree = "Scuderia Ferrari",
                correctAnswer = 3,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 26,
                question = "Who is the most successful team owner in Formula 1 history, leading his team to numerous championships?",
                optionOne = "Frank Williams",
                optionTwo = "Ron Dennis",
                optionThree = "Enzo Ferrari",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 27,
                question = "Which Formula 1 team was previously known as 'Benetton Formula'?",
                optionOne = "Alpine F1 Team",
                optionTwo = "Aston Martin Cognizant Formula One Team",
                optionThree = "Scuderia Ferrari",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 28,
                question = "Which team won the first-ever Formula 1 Constructors' Championship in 1958?",
                optionOne = "Ferrari",
                optionTwo = "Mercedes",
                optionThree = "Cooper",
                correctAnswer = 3,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 29,
                question = "In which year did Lotus F1 Team win their last Constructors' Championship?",
                optionOne = "1978",
                optionTwo = "1986",
                optionThree = "1994",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 30,
                question = "Which team won the Formula 1 Constructors' Championship in the inaugural season of the championship in 1950?",
                optionOne = "Ferrari",
                optionTwo = "Mercedes",
                optionThree = "Alfa Romeo",
                correctAnswer = 3,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 31,
                question = "Which team is known for its iconic 'Silver Arrows' livery?",
                optionOne = "Red Bull Racing",
                optionTwo = "Mercedes-AMG Petronas Formula One Team",
                optionThree = "McLaren",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 32,
                question = "Who founded the McLaren Formula 1 team?",
                optionOne = "Ron Dennis",
                optionTwo = "Bruce McLaren",
                optionThree = "Frank Williams",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 33,
                question = "Which team won the Formula 1 Constructors' Championship in 1997 with the 'Hakkinen vs. Schumacher' rivalry?",
                optionOne = "Ferrari",
                optionTwo = "Williams",
                optionThree = "McLaren",
                correctAnswer = 3,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 34,
                question = "Which Formula 1 team was formerly known as 'Jordan Grand Prix'?",
                optionOne = "Alpine F1 Team",
                optionTwo = "Aston Martin Cognizant Formula One Team",
                optionThree = "Red Bull Racing",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 35,
                question = "Which team is known for its 'Honey Badger' logo?",
                optionOne = "Red Bull Racing",
                optionTwo = "Scuderia Ferrari",
                optionThree = "Aston Martin Cognizant Formula One Team",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 36,
                question = "In which year did Renault return to Formula 1 as a full works team?",
                optionOne = "2010",
                optionTwo = "2016",
                optionThree = "2020",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 37,
                question = "Which team's cars are often referred to as the 'Yellow Teapot'?",
                optionOne = "Alpine F1 Team",
                optionTwo = "AlphaTauri",
                optionThree = "Haas F1 Team",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 38,
                question = "Which British team is known for its 'Orange Arrows' livery?",
                optionOne = "Arrows Grand Prix International",
                optionTwo = "BRM",
                optionThree = "March Engineering",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 39,
                question = "In which year did Alfa Romeo make its return to Formula 1 as a constructor?",
                optionOne = "2017",
                optionTwo = "2018",
                optionThree = "2019",
                correctAnswer = 2,
                category = "Historic Teams"
            )
        )

        questionList.add(
            Question(
                id = 40,
                question = "Which Formula 1 team was known for its 'Sharknose' cars?",
                optionOne = "Ferrari",
                optionTwo = "Maserati",
                optionThree = "Lotus",
                correctAnswer = 1,
                category = "Historic Teams"
            )
        )

        // Records and Statistics Category id: 41-60
        questionList.add(
            Question(
                id = 41,
                question = "Who holds the record for the most consecutive Formula 1 World Drivers' Championships?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Michael Schumacher",
                optionThree = "Juan Manuel Fangio",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 42,
                question = "What is the fastest pit stop time recorded in Formula 1 history?",
                optionOne = "1.82 seconds (Red Bull Racing, 2019)",
                optionTwo = "2.01 seconds (Mercedes-AMG Petronas, 2019)",
                optionThree = "2.29 seconds (Ferrari, 2018)",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 43,
                question = "Which driver holds the record for the most consecutive pole positions in Formula 1?",
                optionOne = "Ayrton Senna",
                optionTwo = "Lewis Hamilton",
                optionThree = "Nigel Mansell",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 44,
                question = "What is the highest speed ever recorded by a Formula 1 car during a race?",
                optionOne = "375 km/h (233 mph)",
                optionTwo = "382 km/h (237 mph)",
                optionThree = "402 km/h (250 mph)",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 45,
                question = "Which driver holds the record for the most Grand Slam victories in Formula 1?",
                optionOne = "Juan Manuel Fangio",
                optionTwo = "Jim Clark",
                optionThree = "Ayrton Senna",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 46,
                question = "What is the record for the most consecutive race wins in a single Formula 1 season?",
                optionOne = "9 wins",
                optionTwo = "11 wins",
                optionThree = "13 wins",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 47,
                question = "Which team holds the record for the most consecutive race wins in Formula 1?",
                optionOne = "Ferrari",
                optionTwo = "Mercedes-AMG Petronas",
                optionThree = "Red Bull Racing",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 48,
                question = "Who is the youngest driver to score points in Formula 1?",
                optionOne = "Max Verstappen",
                optionTwo = "Lando Norris",
                optionThree = "George Russell",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 49,
                question = "Which driver holds the record for the most fastest laps in Formula 1 history?",
                optionOne = "Michael Schumacher",
                optionTwo = "Lewis Hamilton",
                optionThree = "Kimi Räikkönen",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 50,
                question = "What is the record for the most career points scored by a Formula 1 driver?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Sebastian Vettel",
                optionThree = "Michael Schumacher",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 51,
                question = "Which driver holds the record for the most podium finishes in Formula 1?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Michael Schumacher",
                optionThree = "Alain Prost",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 52,
                question = "What is the record for the most consecutive wins at a single Grand Prix?",
                optionOne = "5 wins",
                optionTwo = "7 wins",
                optionThree = "9 wins",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 53,
                question = "Which driver holds the record for the most wins at the Monaco Grand Prix?",
                optionOne = "Ayrton Senna",
                optionTwo = "Lewis Hamilton",
                optionThree = "Michael Schumacher",
                correctAnswer = 1,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 54,
                question = "What is the record for the most wins in a single Formula 1 season?",
                optionOne = "9 wins",
                optionTwo = "11 wins",
                optionThree = "13 wins",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 55,
                question = "Which driver holds the record for the most wins in Formula 1 history?",
                optionOne = "Ayrton Senna",
                optionTwo = "Lewis Hamilton",
                optionThree = "Michael Schumacher",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 56,
                question = "What is the record for the most consecutive World Drivers' Championships won by a single driver?",
                optionOne = "4",
                optionTwo = "7",
                optionThree = "9",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 57,
                question = "Which team holds the record for the most consecutive Constructors' Championships?",
                optionOne = "Ferrari",
                optionTwo = "McLaren",
                optionThree = "Mercedes",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 58,
                question = "What is the record for the most consecutive race starts by a Formula 1 driver?",
                optionOne = "233 races (Nico Hülkenberg)",
                optionTwo = "324 races (Kimi Räikkönen)",
                optionThree = "437 races (Fernando Alonso)",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 59,
                question = "Which driver holds the record for the most consecutive Grand Prix victories in a single season?",
                optionOne = "Ayrton Senna",
                optionTwo = "Michael Schumacher",
                optionThree = "Alberto Ascari",
                correctAnswer = 3,
                category = "Records and Statistics"
            )
        )

        questionList.add(
            Question(
                id = 60,
                question = "What is the record for the most wins in a single season without winning the World Championship?",
                optionOne = "9 wins (Stirling Moss, 1958)",
                optionTwo = "10 wins (Alain Prost, 1984)",
                optionThree = "11 wins (Damon Hill, 1996)",
                correctAnswer = 2,
                category = "Records and Statistics"
            )
        )

        // Epic Races Category id: 61-80
        questionList.add(
            Question(
                id = 61,
                question = "Which Formula 1 race is known for the 'Battle of Britain' between James Hunt and Niki Lauda in 1976?",
                optionOne = "Monaco Grand Prix",
                optionTwo = "British Grand Prix",
                optionThree = "German Grand Prix",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 62,
                question = "In which year did Michael Schumacher famously win the Spanish Grand Prix with just five gears?",
                optionOne = "1994",
                optionTwo = "1996",
                optionThree = "2000",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 63,
                question = "Which race became known as the 'Race of the Century' due to its dramatic conclusion in 1971?",
                optionOne = "Italian Grand Prix",
                optionTwo = "Austrian Grand Prix",
                optionThree = "Spanish Grand Prix",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 64,
                question = "Which Formula 1 race is famous for the 'Duel in the Sun' between Ayrton Senna and Alain Prost in 1984?",
                optionOne = "Monaco Grand Prix",
                optionTwo = "Detroit Grand Prix",
                optionThree = "Portuguese Grand Prix",
                correctAnswer = 3,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 65,
                question = "Which Grand Prix is known for the 'Massacre of Zolder' where Gilles Villeneuve and Didier Pironi collided in 1982?",
                optionOne = "Belgian Grand Prix",
                optionTwo = "San Marino Grand Prix",
                optionThree = "Canadian Grand Prix",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 66,
                question = "In which year did Nigel Mansell famously win the British Grand Prix despite a tire puncture on the last lap?",
                optionOne = "1987",
                optionTwo = "1989",
                optionThree = "1991",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 67,
                question = "Which race is known for the 'Battle of Belgium' between Damon Hill and Michael Schumacher in 1995?",
                optionOne = "Belgian Grand Prix",
                optionTwo = "French Grand Prix",
                optionThree = "Japanese Grand Prix",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 68,
                question = "In which year did Mika Häkkinen win the Luxembourg Grand Prix after a dramatic duel with Michael Schumacher?",
                optionOne = "1998",
                optionTwo = "1999",
                optionThree = "2000",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 69,
                question = "Which race is famous for the 'Sprint to the Line' finish between Lewis Hamilton and Felipe Massa in 2008?",
                optionOne = "Brazilian Grand Prix",
                optionTwo = "Italian Grand Prix",
                optionThree = "Chinese Grand Prix",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 70,
                question = "In which year did Ayrton Senna win the race in Brazil despite gearbox issues?",
                optionOne = "1988",
                optionTwo = "1991",
                optionThree = "1993",
                correctAnswer = 3,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 71,
                question = "Which Grand Prix is known for the 'Race of Attrition' where only six cars finished in 1960?",
                optionOne = "Monaco Grand Prix",
                optionTwo = "Belgian Grand Prix",
                optionThree = "Dutch Grand Prix",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 72,
                question = "In which year did Niki Lauda make a remarkable comeback to racing at the Italian Grand Prix after a near-fatal accident?",
                optionOne = "1978",
                optionTwo = "1979",
                optionThree = "1980",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 73,
                question = "Which race is famous for the 'Last Lap Pass' by Kimi Räikkönen on Giancarlo Fisichella in 2005?",
                optionOne = "Japanese Grand Prix",
                optionTwo = "Hungarian Grand Prix",
                optionThree = "Belgian Grand Prix",
                correctAnswer = 3,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 74,
                question = "In which year did Alain Prost win the Portuguese Grand Prix after a dramatic rain-soaked race?",
                optionOne = "1984",
                optionTwo = "1985",
                optionThree = "1987",
                correctAnswer = 3,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 75,
                question = "Which Grand Prix is known for the 'Great Rivalry' between Alain Prost and Ayrton Senna in the late 1980s?",
                optionOne = "Italian Grand Prix",
                optionTwo = "Japanese Grand Prix",
                optionThree = "Australian Grand Prix",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 76,
                question = "In which year did Juan Manuel Fangio win the German Grand Prix in heavy rain after starting from behind?",
                optionOne = "1954",
                optionTwo = "1956",
                optionThree = "1957",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 77,
                question = "Which race is known for the 'Charge of the Light Brigade' between Stirling Moss and Mike Hawthorn in 1958?",
                optionOne = "Monaco Grand Prix",
                optionTwo = "British Grand Prix",
                optionThree = "Italian Grand Prix",
                correctAnswer = 2,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 78,
                question = "In which year did Gilles Villeneuve win the Spanish Grand Prix despite running out of fuel on the final lap?",
                optionOne = "1978",
                optionTwo = "1980",
                optionThree = "1981",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 79,
                question = "Which Grand Prix is known for the 'Rainmaster' performance by Ayrton Senna in 1984?",
                optionOne = "Portuguese Grand Prix",
                optionTwo = "Monaco Grand Prix",
                optionThree = "Canadian Grand Prix",
                correctAnswer = 3,
                category = "Epic Races"
            )
        )

        questionList.add(
            Question(
                id = 80,
                question = "In which year did Jim Clark win the British Grand Prix in a car with a smaller engine?",
                optionOne = "1963",
                optionTwo = "1965",
                optionThree = "1967",
                correctAnswer = 1,
                category = "Epic Races"
            )
        )

        // 2021 Formula 1 Season Category id:81-100

        questionList.add(
            Question(
                id = 81,
                question = "Who won the Bahrain Grand Prix in the 2021 Formula 1 season?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Max Verstappen",
                optionThree = "Valtteri Bottas",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 82,
                question = "Which circuit hosted the Emilia-Romagna Grand Prix in the 2021 Formula 1 season?",
                optionOne = "Imola",
                optionTwo = "Silverstone",
                optionThree = "Monaco",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 83,
                question = "Which driver scored the first pole position of the 2021 Formula 1 season?",
                optionOne = "Max Verstappen",
                optionTwo = "Lewis Hamilton",
                optionThree = "Valtteri Bottas",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 84,
                question = "In which country did the 2021 Formula 1 season opener take place?",
                optionOne = "Italy",
                optionTwo = "Bahrain",
                optionThree = "Australia",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 85,
                question = "Which team won the Constructors' Championship in the 2021 Formula 1 season?",
                optionOne = "Red Bull Racing",
                optionTwo = "Mercedes-AMG Petronas Formula One Team",
                optionThree = "Scuderia Ferrari",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 86,
                question = "Who scored the most podium finishes in the 2021 Formula 1 season?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Max Verstappen",
                optionThree = "Sergio Pérez",
                correctAnswer = 3,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 87,
                question = "Which race is known for its unique 'sprint qualifying' format introduced in the 2021 season?",
                optionOne = "British Grand Prix",
                optionTwo = "Italian Grand Prix",
                optionThree = "Monaco Grand Prix",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 88,
                question = "Who won the 2021 Formula 1 World Drivers' Championship?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Max Verstappen",
                optionThree = "Valtteri Bottas",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 89,
                question = "Which driver made his Formula 1 debut in the 2021 season with Williams Racing?",
                optionOne = "Nikita Mazepin",
                optionTwo = "George Russell",
                optionThree = "Mick Schumacher",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 90,
                question = "At which circuit did Max Verstappen secure his first victory of the 2021 Formula 1 season?",
                optionOne = "Circuit de Barcelona-Catalunya",
                optionTwo = "Circuit Paul Ricard",
                optionThree = "Red Bull Ring",
                correctAnswer = 3,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 91,
                question = "Which team's cars feature the 'Bull' logo in the 2021 Formula 1 season?",
                optionOne = "Red Bull Racing",
                optionTwo = "Scuderia Ferrari",
                optionThree = "Aston Martin Cognizant Formula One Team",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 92,
                question = "In which country is the Circuit de Monaco located, which hosted the Monaco Grand Prix in the 2021 Formula 1 season?",
                optionOne = "France",
                optionTwo = "Monaco",
                optionThree = "Italy",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 93,
                question = "Who won the inaugural sprint qualifying race in the 2021 Formula 1 season at Silverstone?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Max Verstappen",
                optionThree = "Valtteri Bottas",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 94,
                question = "Which race is known for its iconic 'Eau Rouge' corner, featured in the 2021 Formula 1 season?",
                optionOne = "Singapore Grand Prix",
                optionTwo = "Belgian Grand Prix",
                optionThree = "Hungarian Grand Prix",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 95,
                question = "Which circuit hosted the Turkish Grand Prix in the 2021 Formula 1 season?",
                optionOne = "Istanbul Park",
                optionTwo = "Silverstone",
                optionThree = "Monaco",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 96,
                question = "Who was the youngest driver to win a Formula 1 race in the 2021 season?",
                optionOne = "Max Verstappen",
                optionTwo = "Charles Leclerc",
                optionThree = "Lando Norris",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 97,
                question = "Who won the United States Grand Prix in the 2021 Formula 1 season?",
                optionOne = "Max Verstappen",
                optionTwo = "Lewis Hamilton",
                optionThree = "Sergio Pérez",
                correctAnswer = 1,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 98,
                question = "Which team introduced the 'double diffuser' innovation in the 2021 Formula 1 season?",
                optionOne = "Ferrari",
                optionTwo = "McLaren",
                optionThree = "Red Bull Racing",
                correctAnswer = 3,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 99,
                question = "In which city is the Circuit of the Americas located, which hosted the United States Grand Prix in the 2021 Formula 1 season?",
                optionOne = "New York City",
                optionTwo = "Los Angeles",
                optionThree = "Austin",
                correctAnswer = 3,
                category = "2021 F1 Season"
            )
        )

        questionList.add(
            Question(
                id = 100,
                question = "Who won the 2021 Formula 1 Abu Dhabi Grand Prix?",
                optionOne = "Lewis Hamilton",
                optionTwo = "Max Verstappen",
                optionThree = "Valtteri Bottas",
                correctAnswer = 2,
                category = "2021 F1 Season"
            )
        )

        return questionList
    }


}