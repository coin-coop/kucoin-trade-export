# KuCoin CSV Exporter
Java application to export trades from KuCoin to a CSV file readable by CoinTracking.info. Code uses my own unofficial KuCoin Java API: https://github.com/coin-coop/kucoin-api. In future it will include withdrawals and deposits.

Use program on your own risk.

## Run

1. Run exe file
2. Insert your API and Secret Key (if you copy-paste - use Ctrl+V /Strg+V to paste it)
3. You can constrain download range to certain date range (if empty - it will search for all trades)
4. Choose location and name of the file for download
5. Press Download CSV and wait until all transactions are saved to file

![GUI](docs/gui.png?raw=true "Application GUI")

## Security

After several complains by people about theoretical security issue, I advise that before you use application withdrawal your coins from KuCoin, next start application and download CSV trade history. After finishing remove API and Secret key which you have used for it.

If you don't trust prebuilt exe application feel free to build it by yourself. Run maven build with goal package:

´´´mvn clean package´´´

### Donations

If you find application helpful, feel free to send a coin.

BTC: 3GqgdKYBawTHdCgqNG4yRBbw3ow8RM2Wta

ETH: 0x9b2c6069c0f493af8a175936b560d95f5cf2a49d

LTC: LccbHAxUpnkkTL1xAx91AWcVFAey6iduBK

Waves: 3P7oiqUF65iYu5QXU3KXjqm6yahjowT9Msf

ZEC: t1h1kFYCxnyoQnLLqL9pAAEwD5Y2qPnyN4X