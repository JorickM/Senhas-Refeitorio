<?php

namespace App\Http\Controllers;

use App\Models\Login;
use Illuminate\Http\Request;

class LoginController extends Controller
{

  public function index()
  {
    $logins = Login::all();
    return view('logins.list', compact('logins', 'logins'));
  }



  public function postLoginByEmailPassword(Request $request)
  {
    $login = Login::where('email', $request->email)->where('password', $request->password)->first();
    return response($login, 200);
  }

  public function create()
  {
    return view('logins.create');
  }

  public function store(Request $request)
  {
    $request->validate([
      'txtFirstName' => 'required',
      'txtLastName' => 'required',
      'txtEmail' => 'required',
      'txtPassword' => 'required',
      'txtUrl' => 'required',
    ]);

    $login = new Login([
      'name' => $request->get('txtFirstName'),
      'lastName' => $request->get('txtLastName'),
      'email' => $request->get('txtEmail'),
      'password' => $request->get('txtPassword'),
      'url' => $request->get('txtUrl'),
    ]);

    $login->save();
    return redirect('/logins')->with('success', 'Login has been added');
  }

  public function show(Login $login)
  {
    return view('logins.view', compact('login'));
  }

  public function edit(Login $login)
  {
    return view('logins.edit', compact('login'));
  }


  public function update(Request $request, $codUser)
  {
    $request->validate([
      'txtFirstName' => 'required',
      'txtLastName' => 'required',
      'txtEmail' => 'required',
      'txtPassword' => 'required',
      'txtUrl' => 'required'
    ]);

    $login = Login::find($codUser);
    $login->name = $request->get('txtFirstName');
    $login->lastName = $request->get('txtLastName');
    $login->email = $request->get('txtEmail');
    $login->password = $request->get('txtPassword');
    $login->url = $request->get('txtUrl');

    $login->update();

    return redirect('/logins')->with('success', 'Login updated successfully');
  }

  public function destroy(Login $login)
  {
    $login->delete();
    return redirect('/logins')->with('success', 'Login deleted successfully');
  }
}
