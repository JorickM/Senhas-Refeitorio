<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Login extends Model
{
    use HasFactory;
    protected $table = 'logins';
    protected $fillable = ['name', 'lastName', 'email', 'password', 'url', 'type'];

    public function purchases()
    {
        return $this->belongsToMany(Purchase::class);
    }
}
