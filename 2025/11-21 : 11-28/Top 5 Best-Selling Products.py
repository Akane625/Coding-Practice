# I am not too familiar with data science without pandas or numpy so I had to ask help for certain parts
import csv

def read_csv(files):
  try:
    with open(files, newline="") as file:
      return list(csv.DictReader(file))  # converts the rows into a dictionary
  except FileNotFoundError:
    print("Error: File not found")
    return []
  except Exception as e:
    print("An unexpected error has occured")
    return []

def clean_data(rows):
  cleaned = [i for i in rows if i.get("product") and i.get("quantity") and i.get("price")]  # if its an empty value it returns false and gets removed

  seen = set()  # use set for efficiency
  unique = []
  for i in cleaned:
    key = (i["product"], i["quantity"], i["price"])
    if key not in seen:
      unique.append(i)
      seen.add(key)

  return unique

def calculate_sales(rows):  # no idea how AI came up with this
    try:
        return {product: sum(float(r["quantity"]) * float(r["price"])
        for r in rows if r["product"] == product) 
        for product in {r["product"] for r in rows}
        }
    except ValueError:
        print("Error: Non-numeric values found in quantity/price.")
        return {}

def top_sales(sales_dict):
  return sorted(sales_dict.items(), key=lambda x: x[1], reverse=True)[:5]  # gets top 5 product in sales

rows = read_csv("sales.csv")
cleaned = clean_data(rows)
sales = calculate_sales(cleaned)
top = top_sales(sales)

print("Top 5 best selling products:")
for i, j in top:
  print(f"{i}: {j:.2f}")
