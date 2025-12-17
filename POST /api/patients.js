pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response confirms patient creation", function () {
    pm.expect(pm.response.text()).to.include("Created patient:");
});
