pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response contains Patient ID", function () {
    pm.expect(pm.response.text()).to.include("Patient #");
});
