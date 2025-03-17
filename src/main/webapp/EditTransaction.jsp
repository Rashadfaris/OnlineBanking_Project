<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Transaction</title>
    <style>
        /* Your CSS styles */
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Edit Transaction</h2>
        <form action="edittransfer" method="post">
            <label for="tid">Transaction ID:</label>
            <input type="text" id="tid" name="tid" value="${param.tid}" readonly>
            
            <label for="tpurpose">Purpose:</label>
            <input type="text" id="tpurpose" name="tpurpose" value="${param.purpose}">
            
            <label for="tamount">Amount:</label>
            <input type="number" id="tamount" name="tamount" value="${param.amount}">
            
            <br>
            <button class="save-button" type="submit">Save</button>
        </form>
    </div>
</body>
</html>
